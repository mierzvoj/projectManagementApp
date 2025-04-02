package net.mierzvoj.ProjectManagementApp.user.service.impl;

import lombok.AllArgsConstructor;
import net.mierzvoj.ProjectManagementApp.user.model.User;
import net.mierzvoj.ProjectManagementApp.user.model.UserRequestDTO;
import net.mierzvoj.ProjectManagementApp.user.model.UserResponseDTO;
import net.mierzvoj.ProjectManagementApp.user.repository.UserRepository;
import net.mierzvoj.ProjectManagementApp.user.service.UserService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserResponseDTO saveUser(UserRequestDTO userRequestDTO) {
        User user = new User();
                user.setUserName(userRequestDTO.getUserName());
                user.setEmail(userRequestDTO.getEmail());
                user.setPassword(userRequestDTO.getPassword());


        User savedUser = userRepository.save(user);

        UserResponseDTO savedUserDTO = new UserResponseDTO(
                savedUser.getId(),
                savedUser.getUserName(),
                savedUser.getEmail(),
                null
        );

        return savedUserDTO;
    }
}
