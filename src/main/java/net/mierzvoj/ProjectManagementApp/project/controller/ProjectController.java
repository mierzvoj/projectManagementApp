package net.mierzvoj.ProjectManagementApp.project.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.mierzvoj.ProjectManagementApp.project.model.Project;
import net.mierzvoj.ProjectManagementApp.project.model.ProjectDTO;
import net.mierzvoj.ProjectManagementApp.project.service.impl.ProjectServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects")
@AllArgsConstructor
public class ProjectController {
    private final ProjectServiceImpl projectCreationService;


    @PostMapping("/createFor/{userId}")
    public ResponseEntity<Project> createProject(@RequestBody @Valid ProjectDTO projectDTO, @RequestParam Integer ownerId, @PathVariable Integer userId) {
        Project project = projectCreationService.createProject(projectDTO, ownerId);
        return ResponseEntity.status(HttpStatus.CREATED).body(project);

    }

}
