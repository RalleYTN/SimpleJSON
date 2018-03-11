package de.ralleytn.simple.json.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import de.ralleytn.simple.json.JSONArray;
import de.ralleytn.simple.json.JSONObject;
import de.ralleytn.simple.json.JSONUtil;

/**
 * Tests the {@linkplain JSONUtil} class.
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 2.0.0
 * @since 2.0.0
 */
class JSONUtilTest {

	private static final String UNESCAPED = "ƒ÷‹‰ˆ¸ﬂ≤≥\r\n\b\t\0\\\"'\f/Hello World!";
	private static final String ESCAPED = "ƒ÷‹‰ˆ¸ﬂ≤≥\\r\\n\\b\\t\\u0000\\\\\\\"'\\f\\/Hello World!";
	
	/**
	 * Tests {@link JSONUtil#escape(String)}.
	 * @since 2.0.0
	 */
	@Test
	void testEscape() {
		
		assertEquals(ESCAPED, JSONUtil.escape(UNESCAPED));
		assertNull(JSONUtil.escape(null));
	}
	
	/**
	 * Tests {@link JSONUtil#isJSONType(Object)}.
	 * @since 2.0.0
	 */
	@Test
	void testIsJSONType() {
		
		assertTrue(JSONUtil.isJSONType(null));
		assertTrue(JSONUtil.isJSONType(new JSONObject()));
		assertTrue(JSONUtil.isJSONType(new JSONArray()));
		assertTrue(JSONUtil.isJSONType(new HashMap<>()));
		assertTrue(JSONUtil.isJSONType(new ArrayList<>()));
		assertTrue(JSONUtil.isJSONType("Hello World!"));
		assertTrue(JSONUtil.isJSONType(true));
		assertTrue(JSONUtil.isJSONType(false));
		assertTrue(JSONUtil.isJSONType(0));
		assertTrue(JSONUtil.isJSONType(0.0F));
		assertTrue(JSONUtil.isJSONType(0.00001D));
		assertTrue(JSONUtil.isJSONType(999999999999999999L));
		assertTrue(JSONUtil.isJSONType(new float[] {}));
		assertTrue(JSONUtil.isJSONType(new byte[] {}));
		assertTrue(JSONUtil.isJSONType(new String[] {}));
		assertTrue(JSONUtil.isJSONType(new short[] {}));
		assertTrue(JSONUtil.isJSONType(new int[] {}));
		assertTrue(JSONUtil.isJSONType(new long[] {}));
		assertTrue(JSONUtil.isJSONType(new double[] {}));
		assertTrue(JSONUtil.isJSONType(new char[] {}));
		
		assertFalse(JSONUtil.isJSONType(new Date()));
		assertFalse(JSONUtil.isJSONType(new JSONUtilTest()));
		assertFalse(JSONUtil.isJSONType(new Exception()));
	}
}
