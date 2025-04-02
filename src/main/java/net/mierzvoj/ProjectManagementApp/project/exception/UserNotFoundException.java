package net.mierzvoj.ProjectManagementApp.project.exception;

import net.mierzvoj.ProjectManagementApp.shared.ProjectManagementAppBaseException;
import net.mierzvoj.ProjectManagementApp.shared.error.ErrorCode;

public class UserNotFoundException extends ProjectManagementAppBaseException {
    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause, ErrorCode.USER_NOT_FOUND);
    }
    public UserNotFoundException(String message) {
        super(message, ErrorCode.USER_NOT_FOUND);
    }
}
