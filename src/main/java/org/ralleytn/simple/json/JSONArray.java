/*
 * $Id: JSONArray.java,v 1.1 2006/04/15 14:10:48 platform Exp $
 * Created on 2006-4-10
 */
package org.ralleytn.simple.json;

import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.Collection;

import org.ralleytn.simple.json.internal.Util;

/**
 * A JSON array. JSONObject supports java.util.List interface.
 * 
 * @author FangYidong<fangyidong@yahoo.com.cn>
 */
public class JSONArray extends JSONArrayList {
	
	private static final long serialVersionUID = 3957988303675231981L;
	
	/**
	 * Constructs an empty {@linkplain JSONArray}.
	 * @since 1.0.0
	 */
	public JSONArray() {}
	
	/**
	 * Constructs a {@linkplain JSONArray} with the elements of the given {@linkplain Collection}.
	 * @param collection the {@linkplain Collection}
	 * @since 1.0.0
	 */
	public JSONArray(Collection<?> collection){
		super(collection);
	}
	
	/**
	 * Constructs a {@linkplain JSONArray} with the elements of the given array.
	 * @param array the array
	 * @param <T> the array type
	 * @since 1.0.0
	 */
	public <T>JSONArray(T[] array) {
		for(T element : array) {
			this.add(JSONUtil.getValidJsonValue(element));
		}
	}
	
	/**
	 * Constructs a {@linkplain JSONArray} with the elements of the given array.
	 * @param array the array
	 * @since 1.0.0
	 */
	public JSONArray(byte[] array) {
		
		for(byte element : array) {
			
			this.add(element);
		}
	}
	
	/**
	 * Constructs a {@linkplain JSONArray} with the elements of the given array.
	 * @param array the array
	 * @since 1.0.0
	 */
	public JSONArray(boolean[] array) {
		
		for(boolean element : array) {
			
			this.add(element);
		}
	}
	
	/**
	 * Constructs a {@linkplain JSONArray} with the elements of the given array.
	 * @param array the array
	 * @since 1.0.0
	 */
	public JSONArray(char[] array) {
		
		for(char element : array) {
			
			this.add(element);
		}
	}
	
	/**
	 * Constructs a {@linkplain JSONArray} with the elements of the given array.
	 * @param array the array
	 * @since 1.0.0
	 */
	public JSONArray(short[] array) {
		
		for(short element : array) {
			
			this.add(element);
		}
	}
	
	/**
	 * Constructs a {@linkplain JSONArray} with the elements of the given array.
	 * @param array the array
	 * @since 1.0.0
	 */
	public JSONArray(int[] array) {
		
		for(int element : array) {
			
			this.add(element);
		}
	}
	
	/**
	 * Constructs a {@linkplain JSONArray} with the elements of the given array.
	 * @param array the array
	 * @since 1.0.0
	 */
	public JSONArray(long[] array) {
		
		for(long element : array) {
			
			this.add(element);
		}
	}
	
	/**
	 * Constructs a {@linkplain JSONArray} with the elements of the given array.
	 * @param array the array
	 * @since 1.0.0
	 */
	public JSONArray(float[] array) {
		
		for(float element : array) {
			
			this.add(element);
		}
	}
	
	/**
	 * Constructs a {@linkplain JSONArray} with the elements of the given array.
	 * @param array the array
	 * @since 1.0.0
	 */
	public JSONArray(double[] array) {
		
		for(double element : array) {
			
			this.add(element);
		}
	}
	
	/**
	 * Constructs a {@linkplain JSONArray} from a JSON string.
	 * @param json the JSON string
	 * @throws JSONParseException if the JSON is invalid
	 * @since 1.0.0
	 */
	public JSONArray(String json) throws JSONParseException {
		
		super(new JSONParser().parseJSONArray(json));
	}
	
	/**
	 * Constructs a {@linkplain JSONArray} from JSON data read from a {@linkplain Reader}.
	 * @param reader the {@linkplain Reader}
	 * @throws JSONParseException if the JSON is invalid
	 * @throws IOException if an I/O error occurred
	 * @since 1.0.0
	 */
	public JSONArray(Reader reader) throws JSONParseException, IOException {
		
		super(new JSONParser().parseJSONArray(reader));
	}
	
	/**
	 * Writes this {@linkplain JSONArray} as a JSON string on the given {@linkplain Writer}.
	 * @param writer the {@linkplain Writer}
	 * @throws IOException if an I/O error occurred
	 * @since 1.0.0
	 */
	public void write(Writer writer) throws IOException {
		
		Util.write(this, writer);
	}

	/**
	 * Converts this {@linkplain JSONArray} to a JSON string.
	 * @return this {@linkplain JSONArray} as a JSON string
	 * @since 1.0.0
	 */
	@Override
	public String toString() 
	{
		try(StringWriter writer = new StringWriter()) 
		{	
			Util.write(this, writer);
			return writer.toString();	
		} 
		catch(IOException exception) 
		{
			exception.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public boolean equals(Object object) {
		
		if(object != null) {
			
			if(object instanceof Collection) {
				
				Collection<?> collection = (Collection<?>)object;
				
				if(collection.size() == this.size()) {
					
					int index = 0;
					
					for(Object element : collection) {
						
						if(!((element == null && this.get(index) == null) || this.get(index).equals(element))) {
							
							return false;
						}
						
						index++;
					}
					
					return true;
				}
				
			} else if(object.getClass().isArray()) {
				
				int length = Array.getLength(object);
				
				if(length == this.size()) {
					
					for(int index = 0; index < length; index++) {
						
						Object element = Array.get(object, index);

						if(!((element == null && this.get(index) == null) || element.equals(this.get(index)))) {
							
							return false;
						}
					}
					
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Converts this {@linkplain JSONArray} to a XML string.
	 * @param rootName name of the root element
	 * @return this JSON array as a XML string
	 * @since 1.1.0
	 */
	public String toXML(String rootName) {
		
		StringBuilder builder = new StringBuilder();
		builder.append('<');
		builder.append(rootName);
		builder.append(" length=");
		builder.append(this.size());
		builder.append('>');
		
		for(Object element : this) {

				   if(element instanceof JSONObject) {builder.append(((JSONObject)element).toXML("item"));
			} else if(element instanceof JSONArray) {builder.append(((JSONArray)element).toXML("item"));
			} else {
					
				builder.append("<item>");
				
				if(element != null) {
					
					builder.append(String.valueOf(element));
				}
				
				builder.append("</item>");
			}
		}
		
		builder.append("</");
		builder.append(rootName);
		builder.append('>');
		
		return builder.toString();
	}

}
