package com.pramod.productservice.security;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomJwtAuthenticationConverter implements Converter<Jwt, JwtAuthenticationToken> {

    private final JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();

    @Override
    public JwtAuthenticationToken convert(Jwt jwt) {
        // Extract default authorities (scopes)
        Collection<GrantedAuthority> authorities = grantedAuthoritiesConverter.convert(jwt);

        // Extract roles from the "roles" claim
        List<GrantedAuthority> roleAuthorities = jwt.getClaimAsStringList("roles") // 👈 Ensure "roles" exist in token
                .stream()
                .map(role -> "ROLE_" + role) // Ensure roles follow Spring convention
                .map(org.springframework.security.core.authority.SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        // Combine scopes and roles
        authorities.addAll(roleAuthorities);

        // Return JwtAuthenticationToken with username and authorities
        return new JwtAuthenticationToken(jwt, authorities);
    }
}
