package com.micorservice.store.productservice.exception;


public class RecordNotFound extends RuntimeException {
    public RecordNotFound(String msg) {
        super(msg);
    }
}
