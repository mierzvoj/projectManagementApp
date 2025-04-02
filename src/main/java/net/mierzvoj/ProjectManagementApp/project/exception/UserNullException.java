package net.mierzvoj.ProjectManagementApp.project.exception;

import net.mierzvoj.ProjectManagementApp.shared.ProjectManagementAppBaseException;
import net.mierzvoj.ProjectManagementApp.shared.error.ErrorCode;

public class UserNullException extends ProjectManagementAppBaseException {
    public UserNullException(String message, Throwable cause) {
        super(message, cause, ErrorCode.USER_NOT_FOUND);
    }
    public UserNullException(String message) {
        super(message, ErrorCode.USER_NOT_FOUND);
    }
}
