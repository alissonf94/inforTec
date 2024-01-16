package com.alison.silva.unifacisa.infortec.dto;

import com.alison.silva.unifacisa.infortec.enums.UserRole;

public record RegisterUserDTO(String name, String cpf, String email, String password, UserRole role ) {

}
