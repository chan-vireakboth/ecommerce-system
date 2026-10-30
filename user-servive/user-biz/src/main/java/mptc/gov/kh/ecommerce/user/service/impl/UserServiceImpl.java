package mptc.gov.kh.ecommerce.user.service.impl;

import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mptc.gov.kh.ecommerce.user.dto.UserCreateRequest;
import mptc.gov.kh.ecommerce.user.dto.UserResponse;
import mptc.gov.kh.ecommerce.user.dto.UserUpdateRequest;
import mptc.gov.kh.ecommerce.user.entity.UserEntity;
import mptc.gov.kh.ecommerce.user.exception.PasswordMismatchException;
import mptc.gov.kh.ecommerce.user.exception.UserNotFoundException;
import mptc.gov.kh.ecommerce.user.exception.UsernameConflictException;
import mptc.gov.kh.ecommerce.user.mapper.UserMapper;
import mptc.gov.kh.ecommerce.user.repository.UserRepository;
import mptc.gov.kh.ecommerce.user.service.KeycloakRoleService;
import mptc.gov.kh.ecommerce.user.service.KeycloakUserService;
import mptc.gov.kh.ecommerce.user.service.UserService;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final KeycloakUserService keycloakUserService;
    private final KeycloakRoleService keycloakRoleService;

    @Override
    public UserResponse create(UserCreateRequest userCreateRequest) {
        UserEntity userEntity = userMapper.toEntity(userCreateRequest);

        //validate username
        if(userRepository.existsByUsername(userCreateRequest.username())){
            throw new UsernameConflictException(
                    HttpStatus.CONFLICT, "Username already exists"
            );
        }

        if(!userCreateRequest.password().equals(userCreateRequest.confirmedPassword())){
            throw new PasswordMismatchException(HttpStatus.BAD_REQUEST,
                    "Password does not match");
        }

        UserRepresentation userRepresentation = userMapper.toRepresentation(userCreateRequest);
        userRepresentation.setEnabled(true);
        userRepresentation.setEmailVerified(false);

        CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
        credentialRepresentation.setType(CredentialRepresentation.PASSWORD);
        credentialRepresentation.setValue(userCreateRequest.password());

        userRepresentation.setCredentials(List.of(credentialRepresentation));

        keycloakUserService.createKeycloakUser(userRepresentation);
        UserRepresentation createdUser = keycloakUserService.getKeycloakUserByUsername(
                userEntity.getUsername()
        );
        log.info("User created: {}", createdUser);
        keycloakRoleService.assignRoles(createdUser.getId(), userCreateRequest.roleName());

        // Saving user into database
        userEntity.setId(createdUser.getId());
        userRepository.save(userEntity);

        return userMapper.toResponse(userEntity, createdUser);
    }

    @Override
    public UserResponse update(String id, UserUpdateRequest userUpdateRequest) {
        UserEntity userEntity = userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException(
                        "User not found",
                        HttpStatus.NOT_FOUND
                                ));
        userMapper.toEntity(userUpdateRequest, userEntity);
        userRepository.save(userEntity);

        UserRepresentation userRepresentation = keycloakUserService
                .getKeycloakUserByUsername(userEntity.getUsername());

        if (!(userUpdateRequest.familyName() == null && userUpdateRequest.givenName() == null)){
            if (userUpdateRequest.familyName() != null) {
                userRepresentation.setFirstName(userUpdateRequest.familyName());
            }

            if (userUpdateRequest.givenName() != null) {
                userRepresentation.setLastName(userUpdateRequest.givenName());
            }
            keycloakUserService.updateKeycloakUser(id, userRepresentation);
        }

        return userMapper.toResponse(userEntity, userRepresentation);
    }

    @Override
    public UserResponse getUserById(String id) {
        UserEntity userEntity = userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException(
                        "User not found",
                        HttpStatus.NOT_FOUND
                ));
        UserRepresentation userRepresentation = keycloakUserService.getKeycloakUserById(id);
        return userMapper.toResponse(
                userEntity,
                userRepresentation
        );
    }

    @Override
    public UserResponse getUserByUsername(String username) {
        UserEntity userEntity = userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(
                        "User not found",
                        HttpStatus.NOT_FOUND
                ));
        UserRepresentation userRepresentation = keycloakUserService.getKeycloakUserById(userEntity.getId());
        return userMapper.toResponse(
                userEntity,
                userRepresentation
        );
    }

    @Override
    public List<UserResponse> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(userEntity -> userMapper.toResponse(
                        userEntity,
                        keycloakUserService.getKeycloakUserById(userEntity.getId())
                ))
                .toList();
    }

    @Override
    public List<UserResponse> getUsersByRoleName(String roleName) {
        return keycloakRoleService.getKeycloakUsersByRoleName(roleName)
                .stream()
                .flatMap(userRepresentation -> userRepository
                        .findById(userRepresentation.getId())
                        .map(userEntity -> userMapper.toResponse(userEntity, userRepresentation))
                        .stream())
                .toList();
    }

    @Override
    public void delete(String id) {
        UserEntity userEntity = userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException(
                        "User not found",
                        HttpStatus.NOT_FOUND
                ));
        keycloakUserService.deleteKeycloakUser(id);
        userRepository.delete(userEntity);
    }
}
