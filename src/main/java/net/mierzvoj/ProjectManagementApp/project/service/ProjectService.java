package net.mierzvoj.ProjectManagementApp.project.service;

import jakarta.validation.constraints.Email;
import net.mierzvoj.ProjectManagementApp.project.model.Project;
import net.mierzvoj.ProjectManagementApp.project.model.ProjectDTO;

import java.util.List;

public interface ProjectService {

    Project createProject(ProjectDTO projectDTO, Integer ownerId);
    Project getProjectById(Integer projectId);
    List<Project> getProjectsByOwnerId(Integer ownerId);
    List<Project> getAllProjects();
    List<Project> getProjectsByOwnersEmail(@Email(message="Invalid email format") String email);
}
