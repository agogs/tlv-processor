package com.mobileiron.tlv.processor;

import com.mobileiron.tlv.model.TLVString;

/**
 * This interface defines the methods required for a TLV processor
 */
public interface TLVProcessor {

    /**
     * Process the input string and return the processed string
     *
     * @param input - input {@link TLVString} object
     * @return - the processed string encapsulated in the {@link TLVString} object
     */
    TLVString process(TLVString input);

    /**
     * This enum defines the types of TLV processors
     */
    enum ProcessorType {
        UPPRCS,
        REPLCE;
    }
}
