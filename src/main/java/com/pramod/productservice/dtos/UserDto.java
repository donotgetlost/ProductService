package com.pramod.productservice.dtos;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private String username;
    private String email;
    private List<Role> roles;
}
