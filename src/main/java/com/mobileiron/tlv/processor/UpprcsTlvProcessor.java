package com.mobileiron.tlv.processor;

import com.mobileiron.tlv.model.TLVString;
import org.springframework.stereotype.Service;

/**
 * This TLV processor converts the input string into uppercase characters.
 */
@Service
public class UpprcsTlvProcessor implements TLVProcessor {

    /**
     * Convert the input string into uppercase characters
     * If the input string is already uppercase then do not convert,
     * just return the input string as is.
     *
     * @param input - input string
     * @return - the processed string encapsulated in the {@link TLVString} object
     */
    @Override
    public TLVString process(TLVString input) {

        String inputValue = input.getValue();
        String upperCaseValue = input.getValue().toUpperCase();

        //don't do the conversion if the input string is already uppercase
        if (isUpperCase(inputValue)) {
            return input;
        } else {
            //construct a new TLVString object with the converted value
            return new TLVString(input.getProcessorType(), input.getLength(), upperCaseValue);
        }
    }

    /**
     * Check if the input string is uppercase
     *
     * @param string - input string
     * @return - true if the string is uppercase, false otherwise
     */
    private static boolean isUpperCase(String string) {
        for (int i = 0; i < string.length(); i++) {
            //we check for the lowercase characters
            // because if the string has a non alphabet character then Character.isUppercase() returns false
            // For example Character.isUpperCase("AIN'T UPPERCASE") returns false.
            if (Character.isLowerCase(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
