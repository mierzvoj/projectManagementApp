package net.mierzvoj.ProjectManagementApp.task.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.mierzvoj.ProjectManagementApp.user.model.UserRequestDTO;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskSummaryDTO {
    private Long id;
    private String title;
    private TaskStatus status;
    private LocalDateTime dueDate;
    private UserRequestDTO assignee;
}
