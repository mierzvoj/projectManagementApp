package net.mierzvoj.ProjectManagementApp.task.repository;

import net.mierzvoj.ProjectManagementApp.project.model.Project;
import net.mierzvoj.ProjectManagementApp.task.model.Task;
import net.mierzvoj.ProjectManagementApp.task.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByProject(Project project);
    List<Task> findByProjectAndStatus(Project project, TaskStatus status);

    @Query("SELECT t FROM Task t WHERE t.dueDate < CURRENT_DATE AND t.status != :completedStatus")
    List<Task> findOverdueTasks(@Param("completedStatus") TaskStatus completedStatus);
}
