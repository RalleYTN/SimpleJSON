package de.ralleytn.simple.json.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class JSONArrayTest {
	
	private static final String EXPECTED_NUMBER_ARRAY = "[1,2,3.5,1.0E-4,99999999999999999]";
	private static final String EXPECTED_NUMBER_STRING_ARRAY = "[\"1\",\"2\",\"3.5\",\"0.0001\",\"99999999999999999\"]";
	private static final String EXPECTED_STRING_ARRAY = "[\"A\",\"AB\",\"C\",\"Z\",\"HHH\"]";
	private static final String EXPECTED_ARRAY = "[\"Hello World\",{\"att1\":\"Hello World!\",\"att2\":\"Hello World! 2\"},null,999,\"ƒ÷‹‰ˆ¸ﬂ\"]";
	
	@Test
	void testGetters() {
		
		
	}
	
	@Test
	void testConversions() {
		
		
	}
	
	@Test
	void testToXML() {
		
		
	}
	
	@Test
	void testConstructors() {
		
		
	}
	
	@Test
	void testWrite() {
		
		
	}
	
	@Test
	void testToString() {
		
		assertEquals(EXPECTED_ARRAY, TestUtil.createArray().toString());
		assertEquals(EXPECTED_STRING_ARRAY, TestUtil.createStringArray().toString());
		assertEquals(EXPECTED_NUMBER_ARRAY, TestUtil.createNumberArray().toString());
		assertEquals(EXPECTED_NUMBER_STRING_ARRAY, TestUtil.createNumberStringArray().toString());
	}
}
