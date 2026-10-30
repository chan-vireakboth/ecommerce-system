package mptc.gov.kh.ecommerce.user.service.impl;

import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mptc.gov.kh.ecommerce.user.config.KeycloakAdminClientConfig;
import mptc.gov.kh.ecommerce.user.exception.KeycloakException;
import mptc.gov.kh.ecommerce.user.service.KeycloakUserService;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KeycloakUserServiceImpl implements KeycloakUserService {

    private final Keycloak keycloak;

    @Override
    public void createKeycloakUser(UserRepresentation userRepresentation) {
        try (Response response = keycloak.realm(KeycloakAdminClientConfig.REALM_NAME)
                .users()
                .create(userRepresentation)) {
            if (response.getStatus() != HttpStatus.CREATED.value()) {
                throw new KeycloakException(
                        HttpStatus.valueOf(response.getStatus()),
                        "Create user in keycloak failed with status " + response.getStatus()
                );
            }
        }
    }

    @Override
    public UserRepresentation getKeycloakUserByUsername(String username) {
        return keycloak.realm(KeycloakAdminClientConfig.REALM_NAME)
                .users()
                .search(username, true)
                .stream()
                .findFirst()
                .orElseThrow(() -> new KeycloakException(
                        HttpStatus.NOT_FOUND,
                        "User in Keycloak not found"
                ));
    }

    @Override
    public void updateKeycloakUser(String id,UserRepresentation userRepresentation) {
        try {keycloak.realm(KeycloakAdminClientConfig.REALM_NAME)
                .users()
                .get(id)
                .update(userRepresentation);
    } catch (Exception e){
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public UserRepresentation getKeycloakUserById(String id) {
        return keycloak.realm(KeycloakAdminClientConfig.REALM_NAME)
                .users()
                .get(id)
                .toRepresentation();
    }
}