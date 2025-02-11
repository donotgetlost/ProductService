package com.pramod.productservice.commons;

import com.pramod.productservice.dtos.UserDto;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthCommon {

    private RestTemplate restTemplate;

    public AuthCommon(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDto validateToken(String token) {
        ResponseEntity<UserDto> responseEntity =
                restTemplate.getForEntity(
                        "http://localhost:4040/users/validate/" + token,
                        UserDto.class
                );

        if (responseEntity.getBody() == null) {
            //token is invalid.
            //Throw some exception here.
            return null;
        }

        return responseEntity.getBody();
    }
}
