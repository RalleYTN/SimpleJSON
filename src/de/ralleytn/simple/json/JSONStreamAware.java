package de.ralleytn.simple.json;

import java.io.IOException;
import java.io.Writer;

/**
 * Beans that support customized output of JSON text to a writer shall implement this interface.  
 * @author FangYidong(fangyidong@yahoo.com.cn)
 * @version 1.0.0
 * @since 1.0.0
 */
public interface JSONStreamAware {
	
	/**
	 * Writes a JSON encoded string on a {@linkplain Writer}.
	 * @param the {@linkplain Writer} to write on
	 * @since 1.0.0
	 */
	public void writeJSONString(Writer writer) throws IOException;
}
