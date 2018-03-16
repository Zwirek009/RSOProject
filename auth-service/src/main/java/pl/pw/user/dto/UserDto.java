package pl.pw.user.dto;

import lombok.Value;

@Value
public class UserDto {
    private final String name;
    private final String password;
    private final String emailAddress;
    private final String role;
}
