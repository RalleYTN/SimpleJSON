package de.ralleytn.simple.json;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * @author FangYidong<fangyidong@yahoo.com.cn>
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.0.0
 * @since 1.0.0
 */
public class JSONValue {
	
	private static final String TIME_FORMAT_PATTERN = "yyyy-MM-dd'T'HH:mm:ssZ";
	private static final DateFormat DATETIME_FORMAT_JAVA5 = new SimpleDateFormat(JSONValue.TIME_FORMAT_PATTERN);
	private static final DateTimeFormatter DATETIME_FORMAT_JAVA8 = DateTimeFormatter.ofPattern(JSONValue.TIME_FORMAT_PATTERN);
	private static final DateTimeFormatter DATE_FORMAT_JAVA8 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private static final DateTimeFormatter TIME_FORMAT_JAVA8 = DateTimeFormatter.ofPattern("HH:mm:ss");
	
    /**
     * Encode an object into JSON text and write it to out.
     * <p>
     * If this object is a Map or a List, and it's also a JSONStreamAware or a JSONAware, JSONStreamAware or JSONAware will be considered firstly.
     * <p>
     * DO NOT call this method from writeJSONString(Writer) of a class that implements both JSONStreamAware and (Map or List) with 
     * "this" as the first parameter, use JSONObject.writeJSONString(Map, Writer) or JSONArray.writeJSONString(List, Writer) instead. 
     * 
     * @see de.ralleytn.simple.json.JSONObject#writeJSONString(Map, Writer)
     * @see de.ralleytn.simple.json.JSONArray#writeJSONString(List, Writer)
     * 
     * @param value
     * @param writer
     */
	@SuppressWarnings("unchecked")
	public static void writeJSONString(Object value, Writer out) throws IOException {
		
		if(value == null) {
			
			out.write("null");
			
		} else if(value instanceof String) {
			
            out.write('\"');
			out.write(JSONValue.escape((String)value));
            out.write('\"');
            
		} else if(value instanceof Date) {
			
			out.write('\"');
			out.write(JSONValue.DATETIME_FORMAT_JAVA5.format((Date)value));
            out.write('\"');
            
		} else if(value instanceof LocalDateTime) {
			
			out.write('\"');
			out.write(((LocalDateTime)value).format(JSONValue.DATETIME_FORMAT_JAVA8));
            out.write('\"');
            
		} else if(value instanceof LocalDate) {
			
			out.write('\"');
			out.write(((LocalDate)value).format(JSONValue.DATE_FORMAT_JAVA8));
            out.write('\"');
			
		} else if(value instanceof LocalTime) {
            
			out.write('\"');
			out.write(((LocalTime)value).format(JSONValue.TIME_FORMAT_JAVA8));
            out.write('\"');
            
		} else if(value instanceof OffsetDateTime) {
			
			out.write('\"');
			out.write(((OffsetDateTime)value).format(JSONValue.DATETIME_FORMAT_JAVA8));
            out.write('\"');
            
		} else if(value instanceof OffsetTime) {
			
			out.write('\"');
			out.write(((OffsetTime)value).format(JSONValue.TIME_FORMAT_JAVA8));
            out.write('\"');
            
		} else if(value instanceof ZonedDateTime) {
			
			out.write('\"');
			out.write(((ZonedDateTime)value).format(JSONValue.DATETIME_FORMAT_JAVA8));
            out.write('\"');
			
		} else if(value instanceof Instant)           {JSONValue.writeJSONString(new Date(((Instant)value).toEpochMilli()), out);
		} else if(value instanceof Double)            {out.write(((Double)value).isInfinite() || ((Double)value).isNaN() ? "null" : value.toString());
		} else if(value instanceof Float)             {out.write(((Float)value).isInfinite() || ((Float)value).isNaN() ? "null" : value.toString());
		} else if(value instanceof Number)            {out.write(value.toString());
		} else if(value instanceof Boolean)           {out.write(value.toString());
		} else if((value instanceof JSONStreamAware)) {((JSONStreamAware)value).writeJSONString(out);
		} else if((value instanceof JSONAware))       {out.write(((JSONAware)value).toJSONString());
		} else if(value instanceof Map)               {JSONObject.writeJSONString((Map<Object, Object>)value, out);
		} else if(value instanceof Collection)        {JSONArray.writeJSONString((Collection<Object>)value, out);
		} else if(value instanceof byte[])            {JSONArray.writeJSONString((byte[])value, out);
		} else if(value instanceof short[])           {JSONArray.writeJSONString((short[])value, out);
		} else if(value instanceof int[])             {JSONArray.writeJSONString((int[])value, out);
		} else if(value instanceof long[])            {JSONArray.writeJSONString((long[])value, out);
		} else if(value instanceof float[])           {JSONArray.writeJSONString((float[])value, out);
		} else if(value instanceof double[])          {JSONArray.writeJSONString((double[])value, out);
		} else if(value instanceof boolean[])         {JSONArray.writeJSONString((boolean[])value, out);
		} else if(value instanceof char[])            {JSONArray.writeJSONString((char[])value, out);
		} else if(value.getClass().isArray())         {JSONArray.writeJSONString((Object[])value, out);
		} else {
			
			out.write('"');
			out.write(JSONValue.escape(value.toString()));
			out.write('"');
		}
	}

	/**
	 * Convert an object to JSON text.
	 * <p>
	 * If this object is a Map or a List, and it's also a JSONAware, JSONAware will be considered firstly.
	 * <p>
	 * DO NOT call this method from toJSONString() of a class that implements both JSONAware and Map or List with 
	 * "this" as the parameter, use JSONObject.toJSONString(Map) or JSONArray.toJSONString(List) instead. 
	 * 
	 * @see de.ralleytn.simple.json.JSONObject#toJSONString(Map)
	 * @see de.ralleytn.simple.json.JSONArray#toJSONString(List)
	 * 
	 * @param value
	 * @return JSON text, or "null" if value is null or it's an NaN or an INF number.
	 */
	public static String toJSONString(Object value){

		try(StringWriter writer = new StringWriter()) {
			
			writeJSONString(value, writer);
			return writer.toString();
			
		} catch(IOException exception){

			throw new RuntimeException(exception);
		}
	}

	/**
	 * Escape quotes, \, /, \r, \n, \b, \f, \t and other control characters (U+0000 through U+001F).
	 * @param string the {@linkplain String} you want to escape
	 * @return the escaped {@linkplain String}
	 * @since 1.0.0
	 */
	public static final String escape(String string) {
		
		if(string != null) {
			
			StringBuilder builder = new StringBuilder();
	        JSONValue.escape(string, builder);
	        return builder.toString();
		}

		return null;
    }

    static void escape(String string, StringBuilder builder) {
    	
    	for(int index = 0; index < string.length(); index++) {
    		
    		char character = string.charAt(index);
    		
    		// If is faster than Switch
    		       if(character == '"')  {builder.append("\\\"");
    		} else if(character == '\\') {builder.append("\\\\");
    		} else if(character == '\b') {builder.append("\\b");
    		} else if(character == '\f') {builder.append("\\f");
    		} else if(character == '\n') {builder.append("\\n");
    		} else if(character == '\r') {builder.append("\\r");
    		} else if(character == '\t') {builder.append("\\t");
    		} else if(character == '/')  {builder.append("\\/");
    		} else {
    			
    			if((character >= '\u0000' && character <= '\u001F') ||
    			   (character >= '\u007F' && character <= '\u009F') ||
    			   (character >= '\u2000' && character <= '\u20FF')) {
    				
    				String hex = Integer.toHexString(character);
					builder.append("\\u");
					
					for(int k = 0; k < (4 - hex.length()); k++) {
						
						builder.append('0');
					}
					
					builder.append(hex.toUpperCase());
					
    			} else {
    				
    				builder.append(character);
    			}
    		}
    	}
	}
}
