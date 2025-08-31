package org.Learning.digitalwalletservice;

public class InsufficientfundException extends  RuntimeException {
    public InsufficientfundException(String message) {
        super(message);
    }
}
