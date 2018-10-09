package com.mobileiron.tlv;

import com.mobileiron.tlv.exception.InvalidTlvProcesorType;
import com.mobileiron.tlv.factory.TlvProcessorFactory;
import com.mobileiron.tlv.model.TLVString;
import com.mobileiron.tlv.processor.TLVProcessor;
import com.mobileiron.tlv.util.TLVUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

/**
 * This is the main entry class for this application
 * <p>
 * Reads the input string from STDIN, identify the type(s) of processor(s)
 * required and call the relevant processors to process the string and
 * print the same on STDOUT
 * </p>
 */
@ComponentScan(basePackages = "com.mobileiron.tlv")
public class TLVApplication {

    @Autowired
    TlvProcessorFactory factory;

    public static void main(String[] args) {

        //use spring autowiring
        ApplicationContext context = new AnnotationConfigApplicationContext(TLVApplication.class);
        TLVApplication app = context.getBean(TLVApplication.class);

        app.processTlvString(args[0]);
    }

    /**
     * Convert the input string into a list of {@link TLVString} object
     * and print the processed value of the TLVString in the format  "TYPE-VALUE"
     * For example, the string "UPPRCS-0005-abcde" will be printed as "UPPRCS-ABCDE"
     *
     * @param inputString
     */
    private void processTlvString(String inputString) {
        //convert the input string into a list of TLVString objects
        List<TLVString> tlvStrings = TLVUtil.getTlvStrings(inputString);

        //iterate through the list and process each TLVString object
        for (TLVString tlv : tlvStrings) {

            TLVProcessor processor = null;
            try {
                processor = factory.getProcessor(tlv.getProcessorType());
                tlv = processor.process(tlv);
            } catch (InvalidTlvProcesorType ip) {
                tlv = new TLVString();
            }

            System.out.println(tlv);
        }
    }
}

