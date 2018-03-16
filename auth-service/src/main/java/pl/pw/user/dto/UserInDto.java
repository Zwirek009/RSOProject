package pl.pw.user.dto;

import lombok.Value;

@Value
public class UserInDto {
    private String name;
    private String password;
    private String role;
}
