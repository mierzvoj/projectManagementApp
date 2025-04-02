package net.mierzvoj.ProjectManagementApp.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserSummaryDTO {
    private Long id;
    private String userName;
    private String email;
}
