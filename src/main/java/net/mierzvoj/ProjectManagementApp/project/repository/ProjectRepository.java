package net.mierzvoj.ProjectManagementApp.project.repository;

import net.mierzvoj.ProjectManagementApp.project.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
