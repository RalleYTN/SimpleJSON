package de.ralleytn.simple.json.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import de.ralleytn.simple.json.JSONArray;

class JSONArrayTest {
	
	private static final String EXPECTED_NUMBER_ARRAY = "[1,2,3.5,1.0E-4,99999999999999999]";
	private static final String EXPECTED_NUMBER_STRING_ARRAY = "[\"1\",\"2\",\"3.5\",\"0.0001\",\"99999999999999999\"]";
	private static final String EXPECTED_STRING_ARRAY = "[\"A\",\"AB\",\"C\",\"Z\",\"HHH\"]";
	private static final String EXPECTED_ARRAY = "[\"Hello World\",{\"att1\":\"Hello World!\",\"att2\":\"Hello World! 2\"},null,999,\"ÄÖÜäöüß\"]";
	
	private static final String EXPECTED_XML_ARRAY = "<array length=5><item>Hello World</item><item><att1>Hello World!</att1><att2>Hello World! 2</att2></item><item></item><item>999</item><item>ÄÖÜäöüß</item></array>";
	private static final String EXPECTED_XML_NUMBER_ARRAY = "<array length=5><item>1</item><item>2</item><item>3.5</item><item>1.0E-4</item><item>99999999999999999</item></array>";
	private static final String EXPECTED_XML_STRING_ARRAY = "<array length=5><item>A</item><item>AB</item><item>C</item><item>Z</item><item>HHH</item></array>";
	private static final String EXPECTED_XML_NUMBER_STRING_ARRAY = "<array length=5><item>1</item><item>2</item><item>3.5</item><item>0.0001</item><item>99999999999999999</item></array>";
	
	@Test
	public void testGetters() {
		
		
	}
	
	@Test
	public void testConversions() {
		
		
	}
	
	@Test
	public void testToXML() {
		
		assertEquals(EXPECTED_XML_ARRAY, TestUtil.createArray().toXML("array"));
		assertEquals(EXPECTED_XML_STRING_ARRAY, TestUtil.createStringArray().toXML("array"));
		assertEquals(EXPECTED_XML_NUMBER_ARRAY, TestUtil.createNumberArray().toXML("array"));
		assertEquals(EXPECTED_XML_NUMBER_STRING_ARRAY, TestUtil.createNumberStringArray().toXML("array"));
	}
	
	@Test
	public void testConstructors() {
		
		
	}
	
	@Test
	public void testEquals() {
		
		// correct
		float[] arrayCorrect = {0, 1, 2, 3, 4};
		List<Float> listCorrect = Arrays.asList(0F, 1F, 2F, 3F, 4F);
		JSONArray jsonArrayCorrect = new JSONArray(arrayCorrect);
		
		// incorrect
		float[] arrayIncorrect = {71, 389, 21, 8};
		List<Float> listIncorrect = Arrays.asList(0F);
		JSONArray jsonArrayIncorrect = new JSONArray(arrayIncorrect);
		
		// build array
		JSONArray array = new JSONArray();
		array.add(0.0F);
		array.add(1.0F);
		array.add(2.0F);
		array.add(3.0F);
		array.add(4.0F);
		
		// test correct
		assertTrue(array.equals(arrayCorrect));
		assertTrue(array.equals(listCorrect));
		assertTrue(array.equals(jsonArrayCorrect));
		
		// test incorrect
		assertFalse(array.equals(arrayIncorrect));
		assertFalse(array.equals(listIncorrect));
		assertFalse(array.equals(jsonArrayIncorrect));
	}
	
	@Test
	public void testWrite() {
		
		try(StringWriter writer = new StringWriter()) {
			
			TestUtil.createArray().write(writer);
			assertEquals(EXPECTED_ARRAY, writer.toString());
			
		} catch(IOException exception) {
			
			fail(exception);
		}
	}
	
	@Test
	public void testToString() {
		
		assertEquals(EXPECTED_ARRAY, TestUtil.createArray().toString());
		assertEquals(EXPECTED_STRING_ARRAY, TestUtil.createStringArray().toString());
		assertEquals(EXPECTED_NUMBER_ARRAY, TestUtil.createNumberArray().toString());
		assertEquals(EXPECTED_NUMBER_STRING_ARRAY, TestUtil.createNumberStringArray().toString());
	}
}
