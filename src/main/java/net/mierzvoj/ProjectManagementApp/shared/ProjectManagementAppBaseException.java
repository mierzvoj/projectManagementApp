package net.mierzvoj.ProjectManagementApp.shared;

import net.mierzvoj.ProjectManagementApp.shared.error.ErrorCode;

public class ProjectManagementAppBaseException extends RuntimeException {
    private ErrorCode errorCode;

    public ProjectManagementAppBaseException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }


    public ProjectManagementAppBaseException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }


    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
