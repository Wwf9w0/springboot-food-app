package com.food.app.error;

import java.io.Serializable;

public class ExtendedError  implements Serializable {
    private static final long serialVersionUID = -8156331486065960525L;
    private Integer extendedErrorCode;
    private String message;

    public void setExtendedErrorCode(Integer extendedErrorCode) {
        this.extendedErrorCode = extendedErrorCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getExtendedErrorCode() {
        return extendedErrorCode;
    }

    public String getMessage() {
        return message;
    }

    public ExtendedError(Integer extendedErrorCode, String message) {
        this.extendedErrorCode = extendedErrorCode;
        this.message = message;
    }

    private static ExtendedError.ExtendedErrorBuilder builder(){
        return new ExtendedError.ExtendedErrorBuilder();
    }
    public static class ExtendedErrorBuilder{
        private Integer extendedErrorCode;
        private String message;



        ExtendedErrorBuilder(){

        }
        public ExtendedError.ExtendedErrorBuilder extendedErrorCode(Integer extendedErrorCode) {
            this.extendedErrorCode = extendedErrorCode;
            return this;
        }

        public ExtendedError.ExtendedErrorBuilder message(String message){
            this.message = message;
            return this;
        }

        public ExtendedError build(){
            return new ExtendedError(this.extendedErrorCode, this.message);
        }

        @Override
        public String toString() {
            return "ExtendedErrorBuilder{" +
                    "extendedErrorCode=" + extendedErrorCode +
                    ", message='" + message + '\'' +
                    '}';
        }
    }
}
