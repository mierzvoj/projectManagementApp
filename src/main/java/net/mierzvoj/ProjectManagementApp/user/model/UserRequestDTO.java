package net.mierzvoj.ProjectManagementApp.user.model;

import lombok.*;

@Value
@AllArgsConstructor
@Getter
@Setter
public class UserRequestDTO {
    private Long id;
    private String userName;
    private String password;
    private String email;
}
