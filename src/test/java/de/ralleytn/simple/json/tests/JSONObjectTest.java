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

	private static final void checkParsedObject(JSONObject object) {
		
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
		assertEquals("ÄÖÜäöüß", data.get(4));
	}
	
	private static final void checkConstructorWithReader(String json) {
		
		try(StringReader reader = new StringReader(json)) {
			
			checkParsedObject(new JSONObject(reader));
			
		} catch(JSONParseException | IOException exception) {
			
			fail(exception);
		}
	}
	
	@Test
	public void testEquals() {
		
		
	}
	
	@Test
	public void testWrite() {
		
		
	}
	
	@Test
	public void testCompact() {
		
		
	}
	
	@Test
	public void testGetters() {
		
		
	}
	
	@Test
	public void testToXML() {
		
		
	}
	
	@Test
	public void testConstructors() {
		
		try {
			
			// TEST CONSTRUCTORS THAT TAKE IN A STRING TO PARSE
			checkParsedObject(new JSONObject(TestUtil.JSON_MINIMIZED));
			checkParsedObject(new JSONObject(TestUtil.JSON_FORMATTED_CRLF));
			checkParsedObject(new JSONObject(TestUtil.JSON_FORMATTED_NORMAL));
			checkParsedObject(new JSONObject(TestUtil.JSON_FORMATTED_I2));
			checkParsedObject(new JSONObject(TestUtil.JSON_FORMATTED_SPACE));
			checkParsedObject(new JSONObject(TestUtil.JSON_FORMATTED_SPACE_CRLF));
			checkParsedObject(new JSONObject(TestUtil.JSON_FORMATTED_SPACE_I2));
			checkParsedObject(new JSONObject(TestUtil.JSON_FORMATTED_SPACE_CRLF_I2));
			
			// TEST CONSTRUCTORS THAT TAKE IN ANOTHER MAP
			checkParsedObject(new JSONObject(new JSONObject(TestUtil.JSON_MINIMIZED)));
			checkParsedObject(new JSONObject(new JSONObject(TestUtil.JSON_FORMATTED_CRLF)));
			checkParsedObject(new JSONObject(new JSONObject(TestUtil.JSON_FORMATTED_NORMAL)));
			checkParsedObject(new JSONObject(new JSONObject(TestUtil.JSON_FORMATTED_I2)));
			checkParsedObject(new JSONObject(new JSONObject(TestUtil.JSON_FORMATTED_SPACE)));
			checkParsedObject(new JSONObject(new JSONObject(TestUtil.JSON_FORMATTED_SPACE_CRLF)));
			checkParsedObject(new JSONObject(new JSONObject(TestUtil.JSON_FORMATTED_SPACE_I2)));
			checkParsedObject(new JSONObject(new JSONObject(TestUtil.JSON_FORMATTED_SPACE_CRLF_I2)));
			
			// TEST CONSTRUCTORS THAT TAKE IN A READER WITH JSON DATA TO PARSE
			checkConstructorWithReader(TestUtil.JSON_MINIMIZED);
			checkConstructorWithReader(TestUtil.JSON_FORMATTED_CRLF);
			checkConstructorWithReader(TestUtil.JSON_FORMATTED_NORMAL);
			checkConstructorWithReader(TestUtil.JSON_FORMATTED_I2);
			checkConstructorWithReader(TestUtil.JSON_FORMATTED_SPACE);
			checkConstructorWithReader(TestUtil.JSON_FORMATTED_SPACE_CRLF);
			checkConstructorWithReader(TestUtil.JSON_FORMATTED_SPACE_I2);
			checkConstructorWithReader(TestUtil.JSON_FORMATTED_SPACE_CRLF_I2);
			
			// TEST EMPTY CONSTRUCTOR
			JSONObject object = new JSONObject();
			assertTrue(object.isEmpty());
			
		} catch(JSONParseException exception) {
			
			fail(exception);
		}
	}
	
	@Test
	public void testToString() {
		
		assertEquals(TestUtil.JSON_MINIMIZED, TestUtil.createObject().toString());
	}
}
