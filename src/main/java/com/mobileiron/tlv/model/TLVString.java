package com.mobileiron.tlv.model;

import com.mobileiron.tlv.processor.TLVProcessor;

/**
 * This class encapsulates the type, length and value attributes of a TLV string.
 */
public class TLVString {

    private TLVProcessor.ProcessorType processorType;
    private int length;
    private String value;

    public TLVString() {
    }

    /**
     * Parameterized constructor to instantiate the object with the provided values
     *
     * @param processorType - any of the values in {@link com.mobileiron.tlv.processor.TLVProcessor.ProcessorType} enum
     * @param length        - length of the string
     * @param value         - string to be processed
     */
    public TLVString(TLVProcessor.ProcessorType processorType, int length, String value) {
        this.processorType = processorType;
        this.length = length;
        this.value = value;
    }

    public TLVProcessor.ProcessorType getProcessorType() {
        return processorType;
    }

    public int getLength() {
        return length;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.processorType == null ? "Type not valid" : this.processorType + "-" + this.value;
    }
}
