package com.skillhub.service;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KeycloakService {

    private final Keycloak keycloak;

    @Value("${keycloak.realm}")
    private String realm;

    public void createUser(String username, String email, String password) {
        // Création du user
        CredentialRepresentation credential = new CredentialRepresentation();
        credential.setTemporary(false);
        credential.setType(CredentialRepresentation.PASSWORD);
        credential.setValue(password);

        UserRepresentation user = new UserRepresentation();
        user.setEnabled(true);
        user.setUsername(username);
        user.setEmail(email);
        user.setCredentials(List.of(credential));

        Response response = keycloak.realm(realm).users().create(user);

        if (response.getStatus() != 201) {
            throw new RuntimeException("Échec de la création de l'utilisateur dans Keycloak: " + response.getStatus());
        }

        // Affecter le rôle USER
        String userId = response.getLocation().getPath().replaceAll(".*/([^/]+)$", "$1");
        RoleRepresentation userRole = keycloak.realm(realm).roles().get("USER").toRepresentation();

        keycloak.realm(realm).users().get(userId).roles().realmLevel().add(List.of(userRole));
    }
}
