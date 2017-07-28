package de.ralleytn.simple.json.parser;

import java.util.List;
import java.util.Map;

/**
 * Container factory for creating containers for JSON object and JSON array.
 * @see de.ralleytn.simple.json.parser.JSONParser#parse(java.io.Reader, ContainerFactory)
 * @author FangYidong(fangyidong@yahoo.com.cn)
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ContainerFactory {
	
	/**
	 * @return A Map instance to store JSON object, or null if you want to use org.json.simple.JSONObject.
	 * @since 1.0.0
	 */
	public Map<Object, Object> createObjectContainer();
	
	/**
	 * @return A List instance to store JSON array, or null if you want to use org.json.simple.JSONArray.
	 * @since 1.0.0 
	 */
	public List<Object> creatArrayContainer();
}
