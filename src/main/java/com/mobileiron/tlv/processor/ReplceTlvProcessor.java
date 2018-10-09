package com.mobileiron.tlv.processor;

import com.mobileiron.tlv.model.TLVString;
import org.springframework.stereotype.Service;

/**
 * This TLV processor replaces the input string with the value "THIS STRING"
 */
@Service
public class ReplceTlvProcessor implements TLVProcessor {

    private static final String THIS_STRING = "THIS STRING";

    /**
     * Replace the input string with the string "THIS STRING"
     *
     * @param input - input {@link TLVString} object
     * @return - the processed string encapsulated in the {@link TLVString} object
     */
    @Override
    public TLVString process(TLVString input) {
        input.setValue(THIS_STRING);
        return input;
    }
}
