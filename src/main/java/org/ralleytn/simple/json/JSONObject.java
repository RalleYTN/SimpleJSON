/*
 * $Id: JSONObject.java,v 1.1 2006/04/15 14:10:48 platform Exp $
 * Created on 2006-4-10
 */
package org.ralleytn.simple.json;

import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import org.ralleytn.simple.json.internal.Util;

/**
 * A JSON object. Key value pairs are ordered. JSONObject supports java.util.Map interface.
 * 
 * @author FangYidong<fangyidong@yahoo.com.cn>
 * @author jredfox -fixes<dragonofthelakeabcd@gmail.com>
 */
public class JSONObject extends JSONMap {
	
	private static final long serialVersionUID = -503443796854799292L;
	
	/**
	 * Constructs an empty {@linkplain JSONObject}
	 * @since 1.0.0
	 */
	public JSONObject() {}

	/**
	 * Allows creation of a {@linkplain JSONObject} from a {@linkplain Map}. After that, both the
	 * generated {@linkplain JSONObject} and the {@linkplain Map} can be modified independently.
	 * @param map the {@linkplain Map} from which the {@linkplain JSONObject} should be created
	 * @since 1.0.0
	 */
	public JSONObject(Map map) 
	{
		super(map);
	}
	
	/**
	 * Constructs a {@linkplain JSONObject} from JSON data.
	 * @param json the JSON data
	 * @throws JSONParseException if the JSON data is invalid
	 * @since 1.0.0
	 */
	public JSONObject(String json) throws JSONParseException {
		
		super(new JSONParser().parseJSONObject(json));
	}
	
	/**
	 * Constructs a {@linkplain JSONObject} with JSON data from a {@linkplain Reader}.
	 * @param reader the {@linkplain Reader} with the JSON data
	 * @throws IOException if an I/O error occurred
	 * @throws JSONParseException if the JSON is invalid
	 * @since 1.0.0
	 */
	public JSONObject(Reader reader) throws IOException, JSONParseException {
		
		super(new JSONParser().parseJSONObject(reader));
	}
	
	/**
	 * Writes this {@linkplain JSONObject} on a given {@linkplain Writer}.
	 * @param writer the {@linkplain Writer}
	 * @throws IOException if an I/O error occurred
	 * @since 1.0.0
	 */
	public void write(Writer writer) throws IOException {
		
		Util.write(this, writer);
	}
	
	/**
	 * @return a new {@linkplain JSONObject} without any {@code null} values
	 * @since 1.1.0
	 */
	public JSONObject compact() {
		
		JSONObject object = new JSONObject();
		
		this.forEach((key, value) -> {
			
			if(value != null) {
				
				object.put(key, value);
			}
		});
		
		return object;
	}
	
	/**
	 * @return a {@linkplain String} representation of this {@linkplain JSONObject}.
	 * @since 1.0.0
	 */
	@Override
	public String toString() {
		
		try(StringWriter writer = new StringWriter()) {
			
			Util.write(this, writer);
			return writer.toString();
			
		} catch(IOException exception) {

			exception.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public boolean equals(Object object) {
		
		// ==== 17.03.2018 | Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
		// -	Fixed some weird behavior
		// ====
		
		if(object != null && object instanceof Map) {
			
			Map<?, ?> map = (Map<?, ?>)object;
			
			if(this.size() == map.size()) {
				
				for(Map.Entry<Object, Object> thisEntry : this.entrySet()) {
					
					Object key = thisEntry.getKey();
					Object value = thisEntry.getValue();
					
					if(!map.containsKey(key) || !value.equals(map.get(key))) {
						
						System.out.println(key);
						System.out.println(map.get(key));
						System.out.println(value);
						return false;
					}
				}
				
				return true;
			}
		}
		
		return false;
	}

	/**
	 * @param rootName the name of the root element
	 * @return this JSON Object in XML
	 * @since 1.1.0
	 */
	public String toXML(String rootName) {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append('<');
		builder.append(rootName);
		builder.append('>');
		
		this.forEach((key, value) -> {
			
			       if(value instanceof JSONObject) {builder.append(((JSONObject)value).toXML(key.toString()));
			} else if(value instanceof JSONArray)  {builder.append(((JSONArray)value).toXML(key.toString()));
			} else {
				
				builder.append('<');
				builder.append(key);
				builder.append('>');
				
				if(value != null) {
					
					builder.append(String.valueOf(value));
				}
				
				builder.append("</");
				builder.append(key);
				builder.append('>');
			}
		});
		
		builder.append("</");
		builder.append(rootName);
		builder.append('>');
		
		return builder.toString();
	}

}
