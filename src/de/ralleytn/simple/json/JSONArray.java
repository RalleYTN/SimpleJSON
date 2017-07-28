/*
 * $Id: JSONArray.java,v 1.1 2006/04/15 14:10:48 platform Exp $
 * Created on 2006-4-10
 */
package de.ralleytn.simple.json;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Represents a JSON array.
 * @author FangYidong(fangyidong@yahoo.com.cn)
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.0.0
 * @since 1.0.0
 */
public class JSONArray extends ArrayList<Object> implements JSONAware, JSONStreamAware {
	
	private static final long serialVersionUID = 3957988303675231981L;
	
	/**
	 * Constructs an empty {@linkplain JSONArray}.
	 * @since 1.0.0
	 */
	public JSONArray(){
		
		
	}
	
	/**
	 * Constructs a {@linkplain JSONArray} containing the elements of the specified
	 * {@linkplain Collection}, in the order they are returned by the {@linkplain Collection}'s {@linkplain Iterator}.
	 * @param collection the {@linkplain Collection} whose elements are to be placed into this {@linkplain JSONArray}
	 * @since 1.0.0
	 */
	public JSONArray(Collection<?> collection){
		
		super(collection);
	}
	
	/**
	 * 
	 * @param array
	 * @since 1.0.0
	 */
	public <T>JSONArray(T[] array) {
		
		for(T element : array) {
			
			this.add(element);
		}
	}
	
	/**
	 * 
	 * @param array
	 * @since 1.0.0
	 */
	public JSONArray(byte[] array) {
		
		for(byte element : array) {
			
			this.add(element);
		}
	}
	
	/**
	 * 
	 * @param array
	 * @since 1.0.0
	 */
	public JSONArray(boolean[] array) {
		
		for(boolean element : array) {
			
			this.add(element);
		}
	}
	
	/**
	 * 
	 * @param array
	 * @since 1.0.0
	 */
	public JSONArray(char[] array) {
		
		for(char element : array) {
			
			this.add(element);
		}
	}
	
	/**
	 * 
	 * @param array
	 * @since 1.0.0
	 */
	public JSONArray(short[] array) {
		
		for(short element : array) {
			
			this.add(element);
		}
	}
	
	/**
	 * 
	 * @param array
	 * @since 1.0.0
	 */
	public JSONArray(int[] array) {
		
		for(int element : array) {
			
			this.add(element);
		}
	}
	
	/**
	 * 
	 * @param array
	 * @since 1.0.0
	 */
	public JSONArray(long[] array) {
		
		for(long element : array) {
			
			this.add(element);
		}
	}
	
	/**
	 * 
	 * @param array
	 * @since 1.0.0
	 */
	public JSONArray(float[] array) {
		
		for(float element : array) {
			
			this.add(element);
		}
	}
	
	/**
	 * 
	 * @param array
	 * @since 1.0.0
	 */
	public JSONArray(double[] array) {
		
		for(double element : array) {
			
			this.add(element);
		}
	}
	
    /**
     * Encode a list into JSON text and write it to out. 
     * If this list is also a JSONStreamAware or a JSONAware, JSONStreamAware and JSONAware specific behaviours will be ignored at this top level.
     * 
     * @see de.ralleytn.simple.json.JSONValue#writeJSONString(Object, Writer)
     * 
     * @param collection
     * @param writer
     * @since 1.0.0
     */
	public static final void writeJSONString(Collection<?> collection, Writer writer) throws IOException {
		
		if(collection != null) {
			
			boolean first = true;
			Iterator<?> iterator = collection.iterator();
	        writer.write('[');
	        
			while(iterator.hasNext()) {
				
	            if(first) {
	            	
	                first = false;
	                
	            } else {
	            	
	                writer.write(',');
	            }
	            
				Object value = iterator.next();
				
				if(value == null) {
					
					writer.write("null");
					
				} else {
					
					JSONValue.writeJSONString(value, writer);
				}
			}
			
			writer.write(']');
			
		} else {
		
			writer.write("null");
		}
	}
	
	@Override
	public void writeJSONString(Writer writer) throws IOException {
		
		JSONArray.writeJSONString(this, writer);
	}
	
	/**
	 * 
	 * @param array
	 * @param writer
	 * @throws IOException
	 * @since 1.0.0
	 */
	public static final void writeJSONString(byte[] array, Writer writer) throws IOException {
		
		if(array == null) {
			
			writer.write("null");
			
		} else if(array.length == 0) {
			
			writer.write("[]");
			
		} else {
			
			writer.write("[");
			writer.write(""+ array[0]);
			
			for(int index = 1; index < array.length; index++) {
				
				writer.write(",");
				writer.write("" + array[index]);
			}
			
			writer.write("]");
		}
	}
	
	/**
	 * 
	 * @param array
	 * @param writer
	 * @throws IOException
	 * @since 1.0.0
	 */
	public static final void writeJSONString(short[] array, Writer writer) throws IOException {

		if(array == null) {
			
			writer.write("null");
			
		} else if(array.length == 0) {
			
			writer.write("[]");
			
		} else {
			
			writer.write("[");
			writer.write(""+ array[0]);
			
			for(int index = 1; index < array.length; index++) {
				
				writer.write(",");
				writer.write("" + array[index]);
			}
			
			writer.write("]");
		}
	}
	
	/**
	 * 
	 * @param array
	 * @param writer
	 * @throws IOException
	 * @since 1.0.0
	 */
	public static final void writeJSONString(int[] array, Writer writer) throws IOException {

		if(array == null) {
			
			writer.write("null");
			
		} else if(array.length == 0) {
			
			writer.write("[]");
			
		} else {
			
			writer.write("[");
			writer.write(""+ array[0]);
			
			for(int index = 1; index < array.length; index++) {
				
				writer.write(",");
				writer.write("" + array[index]);
			}
			
			writer.write("]");
		}
	}
	
	/**
	 * 
	 * @param array
	 * @param writer
	 * @throws IOException
	 * @since 1.0.0
	 */
	public static final void writeJSONString(long[] array, Writer writer) throws IOException {

		if(array == null) {
			
			writer.write("null");
			
		} else if(array.length == 0) {
			
			writer.write("[]");
			
		} else {
			
			writer.write("[");
			writer.write(""+ array[0]);
			
			for(int index = 1; index < array.length; index++) {
				
				writer.write(",");
				writer.write("" + array[index]);
			}
			
			writer.write("]");
		}
	}
	
	/**
	 * 
	 * @param array
	 * @param writer
	 * @throws IOException
	 * @since 1.0.0
	 */
	public static final void writeJSONString(float[] array, Writer writer) throws IOException {

		if(array == null) {
			
			writer.write("null");
			
		} else if(array.length == 0) {
			
			writer.write("[]");
			
		} else {
			
			writer.write("[");
			writer.write(""+ array[0]);
			
			for(int index = 1; index < array.length; index++) {
				
				writer.write(",");
				writer.write("" + array[index]);
			}
			
			writer.write("]");
		}
	}
	
	/**
	 * 
	 * @param array
	 * @param writer
	 * @throws IOException
	 * @since 1.0.0
	 */
	public static final void writeJSONString(double[] array, Writer writer) throws IOException {

		if(array == null) {
			
			writer.write("null");
			
		} else if(array.length == 0) {
			
			writer.write("[]");
			
		} else {
			
			writer.write("[");
			writer.write(""+ array[0]);
			
			for(int index = 1; index < array.length; index++) {
				
				writer.write(",");
				writer.write("" + array[index]);
			}
			
			writer.write("]");
		}
	}
	
	/**
	 * 
	 * @param array
	 * @param writer
	 * @throws IOException
	 * @since 1.0.0
	 */
	public static final void writeJSONString(boolean[] array, Writer writer) throws IOException {

		if(array == null) {
			
			writer.write("null");
			
		} else if(array.length == 0) {
			
			writer.write("[]");
			
		} else {
			
			writer.write("[");
			writer.write(""+ array[0]);
			
			for(int index = 1; index < array.length; index++) {
				
				writer.write(",");
				writer.write("" + array[index]);
			}
			
			writer.write("]");
		}
	}
	
	/**
	 * 
	 * @param array
	 * @param writer
	 * @throws IOException
	 * @since 1.0.0
	 */
	public static final void writeJSONString(char[] array, Writer writer) throws IOException {

		if(array == null) {
			
			writer.write("null");
			
		} else if(array.length == 0) {
			
			writer.write("[]");
			
		} else {
			
			writer.write("[");
			writer.write(""+ array[0]);
			
			for(int index = 1; index < array.length; index++) {
				
				writer.write(",");
				writer.write("" + array[index]);
			}
			
			writer.write("]");
		}
	}
	
	/**
	 * 
	 * @param array
	 * @param writer
	 * @param <T>
	 * @throws IOException
	 * @since 1.0.0
	 */
	public static final <T>void writeJSONString(T[] array, Writer writer) throws IOException {
		
		if(array == null){
			
			writer.write("null");
			
		} else if(array.length == 0) {
			
			writer.write("[]");
			
		} else {
			
			writer.write("[");
			JSONValue.writeJSONString(array[0], writer);
			
			for(int i = 1; i < array.length; i++){
				
				writer.write(",");
				JSONValue.writeJSONString(array[i], writer);
			}
			
			writer.write("]");
		}
	}
	
	/**
	 * Convert a list to JSON text. The result is a JSON array. 
	 * If this list is also a JSONAware, JSONAware specific behaviors will be omitted at this top level.
	 * 
	 * @see de.ralleytn.simple.json.JSONValue#toJSONString(Object)
	 * 
	 * @param collection
	 * @return JSON text, or "null" if list is null.
	 * @since 1.0.0
	 */
	public static final String toJSONString(Collection<?> collection) {

		try(StringWriter writer = new StringWriter()) {
			
			JSONArray.writeJSONString(collection, writer);
			return writer.toString();
			
		} catch(IOException exception){

			throw new RuntimeException(exception);
		}
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final String toJSONString(byte[] array) {

		try(StringWriter writer = new StringWriter()) {
			
			JSONArray.writeJSONString(array, writer);
			return writer.toString();
			
		} catch(IOException exception){

			throw new RuntimeException(exception);
		}
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final String toJSONString(short[] array) {

		try(StringWriter writer = new StringWriter()) {
			
			JSONArray.writeJSONString(array, writer);
			return writer.toString();
			
		} catch(IOException exception){

			throw new RuntimeException(exception);
		}
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final String toJSONString(int[] array) {

		try(StringWriter writer = new StringWriter()) {
			
			JSONArray.writeJSONString(array, writer);
			return writer.toString();
			
		} catch(IOException exception){

			throw new RuntimeException(exception);
		}
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final String toJSONString(long[] array) {

		try(StringWriter writer = new StringWriter()) {
			
			JSONArray.writeJSONString(array, writer);
			return writer.toString();
			
		} catch(IOException exception){

			throw new RuntimeException(exception);
		}
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final String toJSONString(float[] array) {

		try(StringWriter writer = new StringWriter()) {
			
			JSONArray.writeJSONString(array, writer);
			return writer.toString();
			
		} catch(IOException exception){

			throw new RuntimeException(exception);
		}
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final String toJSONString(double[] array) {

		try(StringWriter writer = new StringWriter()) {
			
			JSONArray.writeJSONString(array, writer);
			return writer.toString();
			
		} catch(IOException exception){

			throw new RuntimeException(exception);
		}
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final String toJSONString(boolean[] array) {

		try(StringWriter writer = new StringWriter()) {
			
			JSONArray.writeJSONString(array, writer);
			return writer.toString();
			
		} catch(IOException exception){

			throw new RuntimeException(exception);
		}
	}
	
	/**
	 * 
	 * @param array
	 * @return
	 * @since 1.0.0
	 */
	public static final String toJSONString(char[] array) {

		try(StringWriter writer = new StringWriter()) {
			
			JSONArray.writeJSONString(array, writer);
			return writer.toString();
			
		} catch(IOException exception){

			throw new RuntimeException(exception);
		}
	}
	
	/**
	 * 
	 * @param array
	 * @param <T>
	 * @return
	 * @since 1.0.0
	 */
	public static final <T>String toJSONString(T[] array) {

		try(StringWriter writer = new StringWriter()) {
			
			JSONArray.writeJSONString(array, writer);
			return writer.toString();
			
		} catch(IOException exception){

			throw new RuntimeException(exception);
		}
	}
	
	@Override
	public String toJSONString(){
		
		return JSONArray.toJSONString(this);
	}

	/**
	 * Returns a string representation of this array. This is equivalent to
	 * calling {@link JSONArray#toJSONString()}.
	 */
	@Override
	public String toString() {
		
		return this.toJSONString();
	}
}
