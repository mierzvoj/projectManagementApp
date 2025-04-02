package net.mierzvoj.ProjectManagementApp.user.service;

import net.mierzvoj.ProjectManagementApp.user.model.UserRequestDTO;
import net.mierzvoj.ProjectManagementApp.user.model.UserResponseDTO;

public interface UserService {
    UserResponseDTO saveUser(UserRequestDTO userRequestDTO);
}
