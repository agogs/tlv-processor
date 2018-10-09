package com.mobileiron.tlv;

import com.mobileiron.tlv.model.TLVString;
import com.mobileiron.tlv.processor.TLVProcessor;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for TLVApplication. The following use cases are covered
 * 1. Uppercase conversion TLV string, eg., UPPRCS-0008-Abcdefgh
 * 2. Replace operation for a  TLV string, eg., REPLCE-0003-123
 * 3. Invalid type for a TLV string
 */
public class TLVProcessorTest {

    /**
     * Test for a valid TLV string for uppercase conversion.
     */
    @Test
    public void upperCaseTlvStringTest() {
        TLVString input = new TLVString(TLVProcessor.ProcessorType.UPPRCS, 4, "abcd");
        TLVString output = new TLVString(TLVProcessor.ProcessorType.UPPRCS, 4, "ABCD");

        TLVProcessor processor = Mockito.mock(TLVProcessor.class);
        Mockito.when(processor.process(input)).thenReturn(output);

        assertEquals(output.getValue(), processor.process(input).getValue());
    }

    /**
     * Test for a valid TLV string for replace operation
     */
    @Test
    public void replaceTlvStringTest() {
        TLVString input = new TLVString(TLVProcessor.ProcessorType.REPLCE, 4, "123");
        TLVString output = new TLVString(TLVProcessor.ProcessorType.REPLCE, 4, "THIS STRING");

        TLVProcessor processor = Mockito.mock(TLVProcessor.class);
        Mockito.when(processor.process(input)).thenReturn(output);

        assertEquals("THIS STRING", processor.process(input).getValue());
    }

    /**
     * Test for an invalid TLV string
     */
    @Test
    public void inValidTlvStringTest() {
        TLVString tlvObject = new TLVString(null, 4, "abcd");

        TLVProcessor processor = Mockito.mock(TLVProcessor.class);
        Mockito.when(processor.process(tlvObject)).thenReturn(tlvObject);

        assertEquals("Type not valid", processor.process(tlvObject).toString());
    }
}
