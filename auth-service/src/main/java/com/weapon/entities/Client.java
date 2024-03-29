package com.weapon.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clientId;

    private String secret;

    private String scopes =
            StringUtils.arrayToCommaDelimitedString(new String[]{"openid"});

    private String authorizedGrantTypes =
            StringUtils.arrayToCommaDelimitedString(new String[]{"authorization_code", "refresh_token", "password"});


    private String authorities = StringUtils.arrayToCommaDelimitedString(new String[]{"ROLE_USER", "ROLE_ADMIN"});

    private String autoApproveScopes = StringUtils.arrayToCommaDelimitedString(new String[]{".*"});

    public Client(String clientId, String secret) {
        this.clientId = clientId;
        this.secret = secret;
    }
}
