package de.ralleytn.simple.json;

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
