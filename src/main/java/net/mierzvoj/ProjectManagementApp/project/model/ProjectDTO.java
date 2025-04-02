package net.mierzvoj.ProjectManagementApp.project.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.mierzvoj.ProjectManagementApp.task.model.TaskSummaryDTO;
import net.mierzvoj.ProjectManagementApp.user.model.UserSummaryDTO;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {
    private Long id;
    @NotBlank(message="Project name is required")
    @Size(min = 3, max = 100, message = "Project name must be between 3 and 100 characters")
    private String name;
    @Size(max = 1000, message="Description cannot exceed 100 characters")
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startDate;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dueDate;
    private ProjectStatus status;

    private UserSummaryDTO owner;

    private Set<UserSummaryDTO> members = new HashSet<>();
    private Set<TaskSummaryDTO> tasks = new HashSet<>();
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
