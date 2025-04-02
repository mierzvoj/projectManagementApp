package net.mierzvoj.ProjectManagementApp.user.controller;

import lombok.RequiredArgsConstructor;
import net.mierzvoj.ProjectManagementApp.user.model.UserRequestDTO;
import net.mierzvoj.ProjectManagementApp.user.model.UserResponseDTO;
import net.mierzvoj.ProjectManagementApp.user.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> saveUser(@RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO savedUser = userService.saveUser(userRequestDTO);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

//    @GetMapping("{userId}")
//    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable("userId") Long userId) {
//        UserResponseDTO userResponseDto = userService.getEmployeeById(employeeId);
//        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
//    }
}
