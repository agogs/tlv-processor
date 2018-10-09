package com.mobileiron.tlv.factory;

import com.mobileiron.tlv.exception.InvalidTlvProcesorType;
import com.mobileiron.tlv.exception.TlvProcessorNotFoundException;
import com.mobileiron.tlv.processor.TLVProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * This factory class can be used to get relevant TlvProcessor implementation
 * based on the ProcessorType.
 */
@Component
public class TlvProcessorFactory {

    @Autowired
    private TLVProcessor replceTlvProcessor;

    @Autowired
    private TLVProcessor upprcsTlvProcessor;

    /**
     * Get a specific implementation of {@link TLVProcessor} based on the processorType parameter
     *
     * @param processorType - indicating the type of processor
     * @return - instance of specific implementation
     */
    public TLVProcessor getProcessor(TLVProcessor.ProcessorType processorType) throws InvalidTlvProcesorType {

        //handle null case
        if (processorType == null) {
            throw new InvalidTlvProcesorType("processorType cannot be null");
        }


        //return the matching TLVProcessor implementation instance
        switch (processorType) {
            case REPLCE:
                return replceTlvProcessor;
            case UPPRCS:
                return upprcsTlvProcessor;
        }

        throw new TlvProcessorNotFoundException("Processor not found for type : " + processorType);
    }
}
