package com.projetos.gerenciador.exception;

public class BusinessException extends RuntimeException {


    private final ErrCode errCode;

    public BusinessException(ErrCode errCode) {
        super(errCode.getMessage());
        this.errCode = errCode;
    }

    public ErrCode getErrCode() {
        return errCode;
    }

}