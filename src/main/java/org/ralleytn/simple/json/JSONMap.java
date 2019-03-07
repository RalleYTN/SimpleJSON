package org.ralleytn.simple.json;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.ralleytn.simple.json.internal.Util;

import com.evilnotch.lib.util.JavaUtil;

/**
 * this is a json map that allows only primitive and other json values into the map
 * @author jredfox
 */
public class JSONMap extends LinkedHashMap<Object, Object>{
	
	public JSONMap()
	{
		super();
	}
	
	public JSONMap(int capacity)
	{
		super(capacity);
	}

	public JSONMap(Map map) {
		super((Map)JSONUtil.getValidJsonValue(map));
	}

	@Override
	public Object put(Object key, Object value)
	{
		value = JSONUtil.getValidJsonValue(value);
		return super.put(key, value);
	}

	@Override
	public Object putIfAbsent(Object key, Object value)
	{
		value = JSONUtil.getValidJsonValue(value);
		return super.putIfAbsent(key, value);
	}
	
	@Override
	public void putAll(Map map)
	{
		map = (Map) JSONUtil.getValidJsonValue(map);
		super.putAll(map);
	}
	
	public Long getLong(Object key)
	{
		return JavaUtil.getLong((Number)this.get(key));
	}

	public Integer getInt(Object key)
	{
		return JavaUtil.getInt((Number)this.get(key));
	}
	
	public Short getShort(Object key)
	{
		return JavaUtil.getShort((Number)this.get(key));
	}
	
	public Byte getByte(Object key)
	{
		return JavaUtil.getByte((Number)this.get(key));
	}
	
	public Double getDouble(Object key)
	{
		return JavaUtil.getDouble((Number)this.get(key));
	}
	
	public Float getFloat(Object key)
	{
		return JavaUtil.getFloat((Number)this.get(key));
	}
	
	public boolean getBoolean(Object key)
	{
		return (boolean) this.get(key);
	}
	
	public char getChar(Object key)
	{
		return this.getString(key).charAt(0);
	}
	
	public String getString(Object key)
	{
		return (String) this.get(key);
	}
	
	public JSONObject getJSONObject(Object key)
	{
		return (JSONObject)this.get(key);
	}
	
	public JSONArray getJSONArray(Object key)
	{
		return (JSONArray)this.get(key);
	}
	
	/**
	 * @param non primitive object arrays are converted into valid json arrays no recursion this converts data into one JSONArray
	 */
	public Object putStaticArray(String key, Object[] value)
	{
		return this.put(key, new JSONArray(value));
	}
	
	public Object putStaticArray(String key, long[] value)
	{
		return this.put(key, new JSONArray(value));
	}
	
	public Object putStaticArray(String key, int[] value)
	{
		return this.put(key, new JSONArray(value));
	}
	
	public Object putStaticArray(String key, short[] value)
	{
		return this.put(key, new JSONArray(value));
	}
	
	public Object putStaticArray(String key, byte[] value)
	{
		return this.put(key, new JSONArray(value));
	}
	
	public Object putStaticArray(String key, double[] value)
	{
		return this.put(key, new JSONArray(value));
	}
	
	public Object putStaticArray(String key, float[] value)
	{
		return this.put(key, new JSONArray(value));
	}
	
	public Object putStaticArray(String key, boolean[] value)
	{
		return this.put(key, new JSONArray(value));
	}
	
	public Object putStaticArray(String key, char[] value)
	{
		return this.put(key, new JSONArray(value));
	}
	
	/**
	 * fetches the json array and converts back to static array. This is unoptimized only call it when needed
	 */
	public String[] getStringArray(String key)
	{
		JSONArray arr = this.getJSONArray(key);
		return JSONUtil.getStringArray(arr);
	}
	
	public long[] getLongArray(String key)
	{
		JSONArray arr = this.getJSONArray(key);
		return JSONUtil.getLongArray(arr);
	}
	
	public int[] getIntArray(String key)
	{
		JSONArray arr = this.getJSONArray(key);
		return JSONUtil.getIntArray(arr);
	}
	
	public short[] getShortArray(String key)
	{
		JSONArray arr = this.getJSONArray(key);
		return JSONUtil.getShortArray(arr);
	}
	
	public byte[] getByteArray(String key)
	{
		JSONArray arr = this.getJSONArray(key);
		return JSONUtil.getByteArray(arr);
	}
	
	public double[] getDoubleArray(String key)
	{
		JSONArray arr = this.getJSONArray(key);
		return JSONUtil.getDoubleArray(arr);
	}
	
	public float[] getFloatArray(String key)
	{
		JSONArray arr = this.getJSONArray(key);
		return JSONUtil.getFloatArray(arr);
	}
	
	public boolean[] getBooleanArray(String key)
	{
		JSONArray arr = this.getJSONArray(key);
		return JSONUtil.getBooleanArray(arr);
	}
	
	public char[] getCharArray(String key)
	{
		JSONArray arr = this.getJSONArray(key);
		return JSONUtil.getCharArray(arr);
	}
	
	/**
	 * If the value already is a {@linkplain Date}, it will be casted and returned.
	 * Otherwise the result of the value's {@link Object#toString()} will be parsed by the given
	 * {@linkplain DateFormat}. The result is returned.
	 * If the actual value is {@code null}, this method will return {@code null}.
	 * @param key key of the value
	 * @param format the {@linkplain DateFormat} to parse the date with
	 * @return a {@linkplain Date} or {@code null}
	 * @throws ParseException if the date could not be parsed
	 * @since 1.0.0
	 */
	public Date getDate(String key, DateFormat format) throws ParseException {
		
		return Util.getDate(this.get(key), format);
	}
	
	/**
	 * add a date into the json object
	 */
	public Object putDate(String key, Date date, DateFormat format)
	{
		return this.put(key, format.format(date));
	}
	
}
