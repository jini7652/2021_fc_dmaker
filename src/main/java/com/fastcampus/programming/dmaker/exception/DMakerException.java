package com.fastcampus.programming.dmaker.exception;

public class DMakerException extends RuntimeException {
    private DmakerErrorCode dmakerErrorCode;
    private String detailMessage;

    public DMakerException(DmakerErrorCode errorCode) {
        super(errorCode.getMessage());
        this.dmakerErrorCode = errorCode;
        this.detailMessage = errorCode.getMessage();
    }

    public DMakerException(DmakerErrorCode errorCode, String detailMessage) {
        super(detailMessage);
        this.dmakerErrorCode = errorCode;
        this.detailMessage = detailMessage;
    }
}
