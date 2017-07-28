package de.ralleytn.simple.json;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Represents a JSON object.
 * @author FangYidong(fangyidong@yahoo.com.cn)
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.0.0
 * @since 1.0.0
 */
public class JSONObject extends LinkedHashMap<Object, Object> implements JSONAware, JSONStreamAware {
	
	private static final long serialVersionUID = -503443796854799292L;
	
	/**
	 * @since 1.0.0
	 */
	public JSONObject() {}

	/**
	 * Allows creation of a {@linkplain JSONObject} from a {@linkplain Map}. After that, both the
	 * generated {@linkplain JSONObject} and the {@linkplain Map} can be modified independently.
	 * @param map map from which the {@linkplain JSONObject} should be created
	 * @since 1.0.0
	 */
	public JSONObject(Map<?, ?> map) {
		
		super(map);
	}

    /**
     * Encode a map into JSON text and write it to out. This method will not close or flush the given writer!
     * If this map is also a JSONAware or JSONStreamAware, JSONAware or JSONStreamAware specific behaviors will be ignored at this top level.
     * @see de.ralleytn.simple.json.JSONValue#writeJSONString(Object, Writer)
     * @param map the map to write
     * @param writer the writer to which the map should be written to
     * @since 1.0.0
     */
	public static final void writeJSONString(Map<?, ?> map, Writer writer) throws IOException {
		
		if(map != null) {
			
			boolean first = true;
			writer.write('{');

			for(Map.Entry<?, ?> entry : map.entrySet()) {
				
				if(first) {
					
	                first = false;
	                
				} else {
					
	                writer.write(',');
				}
				
	            writer.write('\"');
	            writer.write(JSONValue.escape(String.valueOf(entry.getKey())));
	            writer.write('\"');
	            writer.write(':');
	            
				JSONValue.writeJSONString(entry.getValue(), writer);
			}
			
			writer.write('}');
			
		} else {
			
			writer.write("null");
		}
	}

	@Override
	public void writeJSONString(Writer writer) throws IOException {
		
		JSONObject.writeJSONString(this, writer);
	}

	/**
	 * Convert a map to JSON text. The result is a JSON object. 
	 * If this map is also a {@linkplain JSONAware}, {@linkplain JSONAware} specific behaviors will be omitted at this top level.
	 * @see de.ralleytn.simple.json.JSONValue#toJSONString(Object)
	 * @param map
	 * @return JSON text, or "null" if map is {@code null}.
	 * @since 1.0.0
	 */
	public static final String toJSONString(Map<?, ?> map) {

		try(StringWriter writer = new StringWriter()) {
			
			JSONObject.writeJSONString(map, writer);
			return writer.toString();
			
		} catch(IOException exception) {

			throw new RuntimeException(exception);
		}
	}
	
	@Override
	public String toJSONString() {
		
		return JSONObject.toJSONString(this);
	}
	
	@Override
	public String toString() {
		
		return this.toJSONString();
	}
}
