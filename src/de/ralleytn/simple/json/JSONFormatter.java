package de.ralleytn.simple.json;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * 
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 1.0.0
 * @since 1.0.0
 */
public final class JSONFormatter {

	private JSONFormatter() {}
	
	/**
	 * 
	 * @param json
	 * @return
	 * @since 1.0.0
	 */
	public static final String format(String json) {
		
		return JSONFormatter.format(json, 1, true, false);
	}
	
	/**
	 * 
	 * @param json
	 * @param indent
	 * @return
	 * @since 1.0.0
	 */
	public static final String format(String json, int indent) {
		
		return JSONFormatter.format(json, indent, false, false);
	}
	
	/**
	 * 
	 * @param json
	 * @param indent
	 * @param useTabs
	 * @param windowsLineBreak
	 * @return
	 * @since 1.0.0
	 */
	public static final String format(String json, int indent, boolean useTabs, boolean windowsLineBreak) {
		
		return null;
	}
	
	/**
	 * 
	 * @param jsonReader
	 * @param minimizedWriter
	 * @throws IOException
	 * @since 1.0.0
	 */
	public static final void minimize(Reader jsonReader, Writer minimizedWriter) throws IOException {
		
		boolean inString = false;
		char lastChar = '\0';
		int read = -1;
		
		while((read = jsonReader.read()) != -1) {
			
			char character = (char)read;
			
			if(character != '\n' &&
			   character != '\t' &&
			   character != '\b' &&
			   character != '\0' &&
			   character != '\f') {
				
				if(character == '"') {
					
					inString = !(inString && !(lastChar == '\\'));
				}
				
				if(!(character == ' ' && !inString)) {
					
					minimizedWriter.write(character);
				}
			}
			
			lastChar = character;
		}
	}
	
	/**
	 * 
	 * @param json
	 * @return
	 * @since 1.0.0
	 */
	public static final String minimize(String json) {
		
		StringBuilder builder = new StringBuilder();
		boolean inString = false;
		
		for(int index = 0; index < json.length(); index++) {
			
			char character = json.charAt(index);
			
			if(character != '\n' &&
			   character != '\t' &&
			   character != '\b' &&
			   character != '\0' &&
			   character != '\f') {
				
				if(character == '"') {
					
					inString = !(inString && !(index > 1 && json.charAt(index - 1) == '\\'));
				}
				
				if(!(character == ' ' && !inString)) {
					
					builder.append(character);
				}
			}
		}
		
		return builder.toString();
	}
}
