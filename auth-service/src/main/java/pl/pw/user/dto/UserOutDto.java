package pl.pw.user.dto;

import lombok.Value;

@Value
public class UserOutDto {
    private Long id;
    private String name;
    private String role;
}
