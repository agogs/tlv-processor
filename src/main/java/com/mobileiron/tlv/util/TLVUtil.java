package com.mobileiron.tlv.util;

import com.mobileiron.tlv.model.TLVString;
import com.mobileiron.tlv.processor.TLVProcessor.ProcessorType;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class provides utility methods that can be used during processing of the TLV string
 */
public class TLVUtil {

    //regex to capture the type and length
    private static final Pattern pattern = Pattern.compile("(\\w{6})-(\\d{4})");

    /**
     * Extract the type, length and value from the input string.
     * Encapsulate the extracted type, length and value attributes in a {@link TLVString} object
     * and return the list of the {@link TLVString} objects
     *
     * @param tlvString
     * @return
     */
    public static List<TLVString> getTlvStrings(String tlvString) {

        List<TLVString> tlvStringList = new ArrayList<>();

        Matcher matcher = pattern.matcher(tlvString);

        int beginIndex = 0;
        while (matcher.find()) {
            //extract the type and length
            String type = matcher.group(1);
            int length = Integer.valueOf(matcher.group(2));
            //compute the beginIndex to get the value substring
            beginIndex += 12; //(type)6 + (length)4 + (hyphen)2;
            int endIndex = beginIndex + length;

            //extract the value substring and add to the list
            String value = tlvString.substring(beginIndex, endIndex);

            ProcessorType processorType = null;
            try {
                processorType = ProcessorType.valueOf(type);
            } catch (IllegalArgumentException e) {
                System.out.println();
            }
            tlvStringList.add(new TLVString(processorType, length, value));

            //update the value of the beginIndex for next iteration
            beginIndex += length;
        }

        return tlvStringList;
    }
}
