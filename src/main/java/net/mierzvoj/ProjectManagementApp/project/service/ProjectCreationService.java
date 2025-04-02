package net.mierzvoj.ProjectManagementApp.project.service;

import net.mierzvoj.ProjectManagementApp.project.exception.UserNullException;
import net.mierzvoj.ProjectManagementApp.project.model.Project;
import net.mierzvoj.ProjectManagementApp.project.model.ProjectDTO;
import net.mierzvoj.ProjectManagementApp.project.repository.ProjectRepository;
import net.mierzvoj.ProjectManagementApp.user.model.User;
import net.mierzvoj.ProjectManagementApp.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class ProjectCreationService {
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    @Autowired
    public ProjectCreationService(ProjectRepository projectRepository, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }


    Project createProject(ProjectDTO projectDTO, Long ownerId) {
        User owner = userRepository.findById(ownerId).orElseThrow(() -> new UserNullException("User not found with Id" + ownerId));
        Project project = new Project();
        project.setName(projectDTO.getName());
        project.setDescription(projectDTO.getDescription());
        project.setStartDate(projectDTO.getStartDate());
        project.setDueDate(projectDTO.getDueDate());
        project.setStatus(projectDTO.getStatus());
        project.setOwner(owner);
        return projectRepository.save(project);
    }

    public Project createProjectWithMembers(ProjectDTO projectDTO, Long ownerId, List<Long> memberIds) {
        Project project = createProject(projectDTO, ownerId);

        // Add additional members if provided
        if (memberIds != null && !memberIds.isEmpty()) {
            List<User> members = userRepository.findAllById(memberIds);

            for (User member : members) {
                project.addMember(member);
            }

            project = projectRepository.save(project);
        }

        return project;
    }
}

