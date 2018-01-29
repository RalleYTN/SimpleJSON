package de.ralleytn.simple.json;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import de.ralleytn.simple.json.JSONObject;

class JSONObject_Test {

	@Test
	void testEmptyObject() {
		
		JSONObject object = new JSONObject();
		
		// TEST RESULT
		assertNotNull(object, "The object should never be 'null'!");
		assertEquals(0, object.size());
	}
	
	@Test
	void testObjectCreatedThroughTypesafeHashMap() {
		
		Map<String, Object> submap = new HashMap<>();
		submap.put("byte", (byte)100);
		submap.put("boolean", true);
		submap.put("short", (short)1000);
		submap.put("int", (int)10000);
		submap.put("long", 1000000L);
		submap.put("float", 100.25F);
		submap.put("double", 100.00000025D);
		submap.put("string", "Hello World!");
		
		Map<String, Object> map = new HashMap<>();
		map.put("byte", (byte)100);
		map.put("boolean", true);
		map.put("short", (short)1000);
		map.put("int", (int)10000);
		map.put("long", 1000000L);
		map.put("float", 100.25F);
		map.put("double", 100.00000025D);
		map.put("string", "Hello World!");
		map.put("map", submap);
	}
}
