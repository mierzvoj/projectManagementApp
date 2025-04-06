package net.mierzvoj.ProjectManagementApp.user.service.impl;

import lombok.AllArgsConstructor;
import net.mierzvoj.ProjectManagementApp.user.model.User;
import net.mierzvoj.ProjectManagementApp.user.model.UserRequestDTO;
import net.mierzvoj.ProjectManagementApp.user.model.UserResponseDTO;
import net.mierzvoj.ProjectManagementApp.user.repository.UserRepository;
import net.mierzvoj.ProjectManagementApp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);


    @Override
    public UserResponseDTO saveUser(UserRequestDTO userRequestDTO) {
        User user = new User();
                user.setUserName(userRequestDTO.getUserName());
                user.setEmail(userRequestDTO.getEmail());
                user.setPassword(bCryptPasswordEncoder.encode(userRequestDTO.getPassword()));


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
