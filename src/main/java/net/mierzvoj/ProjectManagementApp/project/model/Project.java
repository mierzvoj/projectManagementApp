package net.mierzvoj.ProjectManagementApp.project.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(length = 1000)
    private String description;
    @Column(nullable = false, name = "start_date")
    private LocalDateTime creationDate;
    @Column(nullable = false, name = "due_date")
    private LocalDateTime dueDate;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProjectStatus status = ProjectStatus.PLANNING;

}


enum ProjectStatus {
    PLANNING,
    IN_PROGRESS,
    ON_HOLD,
    COMPLETED,
    CANCELLED,
}