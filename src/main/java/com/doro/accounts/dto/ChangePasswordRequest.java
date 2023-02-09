package com.doro.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChangePasswordRequest {

    private String username;
    private String oldPassword;
    private String newPassword;
}
