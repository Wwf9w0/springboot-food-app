package com.food.app.error;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Error implements Serializable {
    private static final long serialVersionUID = 6364636415424654390L;

    private int code;
    private String message;
    private long timestamp;
    private List<ExtendedError> extendedErrors;
    public List<String> errorInfos;

    public Error() {
    }

    public Error(int code, String message, long timestamp, List<ExtendedError> extendedErrors, List<String> errorInfos) {
        this.code = code;
        this.message = message;
        this.timestamp = timestamp;
        this.extendedErrors = extendedErrors;
        this.errorInfos = errorInfos;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public List<ExtendedError> getExtendedErrors() {
        return extendedErrors;
    }

    public void setExtendedErrors(List<ExtendedError> extendedErrors) {
        this.extendedErrors = extendedErrors;
    }

    public List<String> getErrorInfos() {
        return errorInfos;
    }

    public void setErrorInfos(List<String> errorInfos) {
        this.errorInfos = errorInfos;
    }

    @Override
    public String toString() {
        return "Error{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                ", extendedErrors=" + extendedErrors +
                ", errorInfos=" + errorInfos +
                '}';
    }

    public static class ErrorBuilder{
        private int code;
        private String message;
        private long timestamp;
        private List<ExtendedError> extendedErrors;
        private List<String> errorInfos;

        ErrorBuilder(){

        }

        public Error.ErrorBuilder code (int code){
            this.code = code;
            return this;
        }

        public Error.ErrorBuilder message (String message){
            this.message = message;
            return this;
        }
    }
}
