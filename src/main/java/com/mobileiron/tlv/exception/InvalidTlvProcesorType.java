package com.mobileiron.tlv.exception;

/**
 * This exception is thrown when an invalid processor type is encountered
 */
public class InvalidTlvProcesorType extends Exception {
    public InvalidTlvProcesorType() {
        super();
    }

    public InvalidTlvProcesorType(String message) {
        super(message);
    }
}
