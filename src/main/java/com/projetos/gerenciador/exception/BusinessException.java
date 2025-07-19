package com.projetos.gerenciador.exception;

public class BuisnessException (ErrorCode errorCode){

    private final ErrorCode errorCode;

    public BuisnessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
    public ErrorCode getErrorCode(){
        return errorCode;
    }


}
