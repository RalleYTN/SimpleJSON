package de.ralleytn.simple.json.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.io.StringReader;

import org.junit.jupiter.api.Test;

import de.ralleytn.simple.json.JSONArray;
import de.ralleytn.simple.json.JSONObject;
import de.ralleytn.simple.json.JSONParseException;

class JSONObjectTest {

	private static final void testParsedObject(JSONObject object) {
		
		assertNotNull(object);
		assertFalse(object.isEmpty());
		assertTrue(object.containsKey("status"));
		assertTrue(object.containsKey("data"));
		
		JSONObject status = object.getObject("status");
		assertNotNull(status);
		assertFalse(status.isEmpty());
		assertTrue(status.containsKey("code"));
		assertTrue(status.containsKey("message"));
		assertTrue(status.containsKey("error"));
		assertNotNull(status.getInteger("code"));
		assertNotNull(status.getString("message"));
		assertNull(status.getString("error"));
		assertEquals((Integer)200, status.getInteger("code"));
		assertEquals("OK", status.getString("message"));
		
		JSONArray data = object.getArray("data");
		assertNotNull(data);
		assertFalse(data.isEmpty());
		assertEquals(5, data.size());
		assertNotNull(data.get(0));
		assertNotNull(data.get(1));
		assertNull(data.get(2));
		assertNotNull(data.get(3));
		assertNotNull(data.get(4));
		assertEquals("Hello World", data.get(0));
		assertTrue(data.get(1) instanceof JSONObject);
		assertEquals((Integer)999, data.getInteger(3));
		assertEquals("ƒ÷‹‰ˆ¸ﬂ", data.get(4));
	}
	
	private static final void testConstructorWithReader(String json) {
		
		try(StringReader reader = new StringReader(json)) {
			
			testParsedObject(new JSONObject(reader));
			
		} catch(JSONParseException | IOException exception) {
			
			fail(exception);
		}
	}
	
	@Test
	void testConstructors() {
		
		try {
			
			// Test the constructor that takes in a string to parse
			testParsedObject(new JSONObject(TestUtil.JSON_MINIMIZED));
			testParsedObject(new JSONObject(TestUtil.JSON_FORMATTED_CRLF));
			testParsedObject(new JSONObject(TestUtil.JSON_FORMATTED_NORMAL));
			testParsedObject(new JSONObject(TestUtil.JSON_FORMATTED_I2));
			testParsedObject(new JSONObject(TestUtil.JSON_FORMATTED_SPACE));
			testParsedObject(new JSONObject(TestUtil.JSON_FORMATTED_SPACE_CRLF));
			testParsedObject(new JSONObject(TestUtil.JSON_FORMATTED_SPACE_I2));
			testParsedObject(new JSONObject(TestUtil.JSON_FORMATTED_SPACE_CRLF_I2));
			
			// Test the constructor that takes in a reader with json data to parse
			testConstructorWithReader(TestUtil.JSON_MINIMIZED);
			testConstructorWithReader(TestUtil.JSON_FORMATTED_CRLF);
			testConstructorWithReader(TestUtil.JSON_FORMATTED_NORMAL);
			testConstructorWithReader(TestUtil.JSON_FORMATTED_I2);
			testConstructorWithReader(TestUtil.JSON_FORMATTED_SPACE);
			testConstructorWithReader(TestUtil.JSON_FORMATTED_SPACE_CRLF);
			testConstructorWithReader(TestUtil.JSON_FORMATTED_SPACE_I2);
			testConstructorWithReader(TestUtil.JSON_FORMATTED_SPACE_CRLF_I2);
			
		} catch(JSONParseException exception) {
			
			fail(exception);
		}
	}
	
	@Test
	void testToString() {
		
		assertEquals(TestUtil.JSON_MINIMIZED, TestUtil.createObject().toString());
	}
}
