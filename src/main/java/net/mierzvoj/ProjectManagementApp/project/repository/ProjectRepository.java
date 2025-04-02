package net.mierzvoj.ProjectManagementApp.project.repository;

import net.mierzvoj.ProjectManagementApp.project.model.Project;
import net.mierzvoj.ProjectManagementApp.project.model.ProjectStatus;
import net.mierzvoj.ProjectManagementApp.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    List<Project> findProjectByName(String project_name);

    List<Project> findProjectByStatus(ProjectStatus status);

    List<Project> findByOwner(User owner);

}
