package com.mobileiron.tlv.exception;

/**
 * Runtime exception to handle cases when a processor is not found.
 */
public class TlvProcessorNotFoundException extends RuntimeException {
    public TlvProcessorNotFoundException() {
        super();
    }

    public TlvProcessorNotFoundException(String message) {
        super(message);
    }
}
