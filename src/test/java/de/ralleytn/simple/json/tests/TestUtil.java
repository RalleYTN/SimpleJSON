package de.ralleytn.simple.json.tests;

import de.ralleytn.simple.json.JSONArray;
import de.ralleytn.simple.json.JSONObject;

/**
 * Contains some utility methods that are needed for the test classes.
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 2.0.0
 * @since 2.0.0
 */
final class TestUtil {

	/** @since 2.0.0 */ public static final String JSON_MINIMIZED = "{\"status\":{\"code\":200,\"message\":\"OK\",\"error\":null},\"data\":[\"Hello World\",{\"att1\":\"Hello World!\",\"att2\":\"Hello World! 2\"},null,999,\"ÄÖÜäöüß\"]}";
	/** @since 2.0.0 */ public static final String JSON_FORMATTED_NORMAL = "{\n\t\"status\": {\n\t\t\"code\": 200,\n\t\t\"message\": \"OK\",\n\t\t\"error\": null\n\t},\n\t\"data\": [\n\t\t\"Hello World\",\n\t\t{\n\t\t\t\"att1\": \"Hello World!\",\n\t\t\t\"att2\": \"Hello World! 2\"\n\t\t},\n\t\tnull,\n\t\t999,\n\t\t\"ÄÖÜäöüß\"\n\t]\n}";
	/** @since 2.0.0 */ public static final String JSON_FORMATTED_CRLF = "{\r\n\t\"status\": {\r\n\t\t\"code\": 200,\r\n\t\t\"message\": \"OK\",\r\n\t\t\"error\": null\r\n\t},\r\n\t\"data\": [\r\n\t\t\"Hello World\",\r\n\t\t{\r\n\t\t\t\"att1\": \"Hello World!\",\r\n\t\t\t\"att2\": \"Hello World! 2\"\r\n\t\t},\r\n\t\tnull,\r\n\t\t999,\r\n\t\t\"ÄÖÜäöüß\"\r\n\t]\r\n}";
	/** @since 2.0.0 */ public static final String JSON_FORMATTED_I2 = "{\n\t\t\"status\": {\n\t\t\t\t\"code\": 200,\n\t\t\t\t\"message\": \"OK\",\n\t\t\t\t\"error\": null\n\t\t},\n\t\t\"data\": [\n\t\t\t\t\"Hello World\",\n\t\t\t\t{\n\t\t\t\t\t\t\"att1\": \"Hello World!\",\n\t\t\t\t\t\t\"att2\": \"Hello World! 2\"\n\t\t\t\t},\n\t\t\t\tnull,\n\t\t\t\t999,\n\t\t\t\t\"ÄÖÜäöüß\"\n\t\t]\n}";
	/** @since 2.0.0 */ public static final String JSON_FORMATTED_SPACE = "{\n \"status\": {\n  \"code\": 200,\n  \"message\": \"OK\",\n  \"error\": null\n },\n \"data\": [\n  \"Hello World\",\n  {\n   \"att1\": \"Hello World!\",\n   \"att2\": \"Hello World! 2\"\n  },\n  null,\n  999,\n  \"ÄÖÜäöüß\"\n ]\n}";
	/** @since 2.0.0 */ public static final String JSON_FORMATTED_SPACE_I2 = "{\n  \"status\": {\n    \"code\": 200,\n    \"message\": \"OK\",\n    \"error\": null\n  },\n  \"data\": [\n    \"Hello World\",\n    {\n      \"att1\": \"Hello World!\",\n      \"att2\": \"Hello World! 2\"\n    },\n    null,\n    999,\n    \"ÄÖÜäöüß\"\n  ]\n}";
	/** @since 2.0.0 */ public static final String JSON_FORMATTED_SPACE_CRLF = "{\r\n \"status\": {\r\n  \"code\": 200,\r\n  \"message\": \"OK\",\r\n  \"error\": null\r\n },\r\n \"data\": [\r\n  \"Hello World\",\r\n  {\r\n   \"att1\": \"Hello World!\",\r\n   \"att2\": \"Hello World! 2\"\r\n  },\r\n  null,\r\n  999,\r\n  \"ÄÖÜäöüß\"\r\n ]\r\n}";
	/** @since 2.0.0 */ public static final String JSON_FORMATTED_SPACE_CRLF_I2 = "{\r\n  \"status\": {\r\n    \"code\": 200,\r\n    \"message\": \"OK\",\r\n    \"error\": null\r\n  },\r\n  \"data\": [\r\n    \"Hello World\",\r\n    {\r\n      \"att1\": \"Hello World!\",\r\n      \"att2\": \"Hello World! 2\"\r\n    },\r\n    null,\r\n    999,\r\n    \"ÄÖÜäöüß\"\r\n  ]\r\n}";
	
	private TestUtil() {}
	
	/**
	 * Creates an instance of {@linkplain JSONArray} filled with some numbers but as strings.
	 * @return the created array
	 * @since 2.0.0
	 */
	public static final JSONArray createNumberStringArray() {
		
		JSONArray array = new JSONArray();
		array.add("1");
		array.add("2");
		array.add("3.5");
		array.add("0.0001");
		array.add("99999999999999999");
		
		return array;
	}
	
	/**
	 * Creates an instance of {@linkplain JSONArray} filled with some strings.
	 * @return the created array
	 * @since 2.0.0
	 */
	public static final JSONArray createStringArray() {
		
		JSONArray array = new JSONArray();
		array.add("A");
		array.add("AB");
		array.add("C");
		array.add("Z");
		array.add("HHH");
		
		return array;
	}
	
	/**
	 * Creates an instance of {@linkplain JSONArray} filled with some numbers.
	 * @return the created array
	 * @since 2.0.0
	 */
	public static final JSONArray createNumberArray() {
		
		JSONArray array = new JSONArray();
		array.add(1);
		array.add(2);
		array.add(3.5F);
		array.add(0.0001D);
		array.add(99999999999999999L);
		
		return array;
	}
	
	/**
	 * Creates an instance of {@linkplain JSONArray} with some sample data.
	 * @return the created array
	 * @since 2.0.0
	 */
	public static final JSONArray createArray() {
		
		JSONObject object = new JSONObject();
		object.put("att1", "Hello World!");
		object.put("att2", "Hello World! 2");
		
		JSONArray array = new JSONArray();
		array.add("Hello World");
		array.add(object);
		array.add(null);
		array.add(999);
		array.add("ÄÖÜäöüß");
		
		return array;
	}
	
	/**
	 * Creates an instance of {@linkplain JSONObject} with some sample data.
	 * @return the created instance
	 * @since 2.0.0
	 */
	public static final JSONObject createObject() {
		
		JSONObject status = new JSONObject();
		status.put("code", 200);
		status.put("message", "OK");
		status.put("error", null);
		
		JSONObject json = new JSONObject();
		json.put("status", status);
		json.put("data", TestUtil.createArray());
		
		return json;
	}
}
