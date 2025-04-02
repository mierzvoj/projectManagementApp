package net.mierzvoj.ProjectManagementApp.project.service.impl;

import net.mierzvoj.ProjectManagementApp.project.exception.UserNotFoundException;
import net.mierzvoj.ProjectManagementApp.project.model.Project;
import net.mierzvoj.ProjectManagementApp.project.model.ProjectDTO;
import net.mierzvoj.ProjectManagementApp.project.repository.ProjectRepository;
import net.mierzvoj.ProjectManagementApp.project.service.ProjectService;
import net.mierzvoj.ProjectManagementApp.user.model.User;
import net.mierzvoj.ProjectManagementApp.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    /**
     * Creates a new project and assigns it to the specified owner
     *
     * @param projectDTO Data for creating the project
     * @param ownerId    ID of the user who will own this project
     * @return The created project entity
     * @throws UserNotFoundException If the specified owner doesn't exist
     */
    @Override
    public Project createProject(ProjectDTO projectDTO, Integer ownerId) {
        User owner = userRepository.findById(ownerId).orElseThrow(() -> new UserNotFoundException("User not found with Id" + ownerId));
        Project project = new Project();
        project.setName(projectDTO.getName());
        project.setDescription(projectDTO.getDescription());
        project.setStartDate(projectDTO.getStartDate());
        project.setDueDate(projectDTO.getDueDate());
        project.setStatus(projectDTO.getStatus());
        project.setOwner(owner);
        project.addMember(owner);

        return projectRepository.save(project);
    }

    public Project saveProjectWithMembers(ProjectDTO projectDTO, Integer ownerId, List<Integer> memberIds) {
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

    @Override
    public Project getProjectById(Integer projectId) {
        return null;
    }

    @Override
    public List<Project> getProjectsByOwnerId(Integer ownerId) {
        return List.of();
    }

    @Override
    public List<Project> getAllProjects() {
        return List.of();
    }

    @Override
    public List<Project> getProjectsByOwnersEmail(String email) {
        return List.of();
    }
}