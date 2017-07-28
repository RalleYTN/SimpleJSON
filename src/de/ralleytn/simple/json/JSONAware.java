package de.ralleytn.simple.json;

/**
 * Beans that support customized output of JSON text shall implement this interface.  
 * @author FangYidong(fangyidong@yahoo.com.cn)
 * @version 1.0.0
 * @since 1.0.0
 */
public interface JSONAware {
	
	/**
	 * @return JSON text
	 * @since 1.0.0
	 */
	public String toJSONString();
}
