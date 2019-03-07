package org.ralleytn.simple.json;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.ralleytn.simple.json.internal.Util;

import com.evilnotch.lib.util.JavaUtil;

public class JSONArrayList extends ArrayList<Object>{
	
	public JSONArrayList()
	{
		super();
	}
	
	public JSONArrayList(int capacity)
	{
		super(capacity);
	}

	public JSONArrayList(Collection<?> collection) {
		super((Collection<?>)JSONUtil.getValidJsonValue(collection));
	}

	@Override
	public boolean add(Object obj)
	{
		obj = JSONUtil.getValidJsonValue(obj);
		return super.add(obj);
	}
	
	@Override
	public void add(int index, Object obj)
	{
		obj = JSONUtil.getValidJsonValue(obj);
		super.add(index, obj);
	}
	
	@Override
	public boolean addAll(Collection map)
	{
		map = (Collection) JSONUtil.getValidJsonValue(map);
		return super.addAll(map);
	}
	
	@Override
	public boolean addAll(int index, Collection map)
	{
		map = (Collection) JSONUtil.getValidJsonValue(map);
		return super.addAll(index, map);
	}
	
	public Long getLong(int key)
	{
		return JavaUtil.getLong((Number)this.get(key));
	}

	public Integer getInt(int key)
	{
		return JavaUtil.getInt((Number)this.get(key));
	}
	
	public Short getShort(int key)
	{
		return JavaUtil.getShort((Number)this.get(key));
	}
	
	public Byte getByte(int key)
	{
		return JavaUtil.getByte((Number)this.get(key));
	}
	
	public Double getDouble(int key)
	{
		return JavaUtil.getDouble((Number)this.get(key));
	}
	
	public Float getFloat(int key)
	{
		return JavaUtil.getFloat((Number)this.get(key));
	}
	
	public boolean getBoolean(int key)
	{
		return (boolean) this.get(key);
	}
	
	public char getChar(int key)
	{
		return this.getString(key).charAt(0);
	}
	
	public String getString(int key)
	{
		return (String) this.get(key);
	}
	
	public JSONObject getJSONObject(int key)
	{
		return (JSONObject)this.get(key);
	}
	
	public JSONArray getJSONArray(int key)
	{
		return (JSONArray)this.get(key);
	}
	
	/**
	 * @param non primitive object arrays are converted into valid json arrays no recursion this converts data into one JSONArray
	 */
	public boolean addStaticArray(Object[] value)
	{
		return this.add(new JSONArray(value));
	}
	
	public boolean addStaticArray(long[] value)
	{
		return this.add(new JSONArray(value));
	}
	
	public boolean addStaticArray(int[] value)
	{
		return this.add(new JSONArray(value));
	}
	
	public boolean addStaticArray(short[] value)
	{
		return this.add(new JSONArray(value));
	}
	
	public boolean addStaticArray(byte[] value)
	{
		return this.add(new JSONArray(value));
	}
	
	public boolean addStaticArray(double[] value)
	{
		return this.add(new JSONArray(value));
	}
	
	public boolean addStaticArray(float[] value)
	{
		return this.add(new JSONArray(value));
	}
	
	public boolean addStaticArray(boolean[] value)
	{
		return this.add(new JSONArray(value));
	}
	
	public boolean addStaticArray(char[] value)
	{
		return this.add(new JSONArray(value));
	}
	
	/**
	 * @param non primitive object arrays are converted into valid json arrays no recursion this converts data into one JSONArray
	 */
	public void addStaticArray(int index, Object[] value)
	{
		this.add(index, new JSONArray(value));
	}
	
	public void addStaticArray(int index, long[] value)
	{
		this.add(index, new JSONArray(value));
	}
	
	public void addStaticArray(int index, int[] value)
	{
		this.add(index, new JSONArray(value));
	}
	
	public void addStaticArray(int index, short[] value)
	{
		this.add(index, new JSONArray(value));
	}
	
	public void addStaticArray(int index, byte[] value)
	{
		this.add(index, new JSONArray(value));
	}
	
	public void addStaticArray(int index, double[] value)
	{
		this.add(index, new JSONArray(value));
	}
	
	public void addStaticArray(int index, float[] value)
	{
		this.add(index, new JSONArray(value));
	}
	
	public void addStaticArray(int index, boolean[] value)
	{
		this.add(index, new JSONArray(value));
	}
	
	public void addStaticArray(int index, char[] value)
	{
		this.add(index, new JSONArray(value));
	}
	
	/**
	 * @param non primitive object arrays are converted into valid json arrays no recursion this converts data into one JSONArray
	 */
	public void setStaticArray(int index, Object[] value)
	{
		this.set(index, new JSONArray(value));
	}
	
	public void setStaticArray(int index, long[] value)
	{
		this.set(index, new JSONArray(value));
	}
	
	public void setStaticArray(int index, int[] value)
	{
		this.set(index, new JSONArray(value));
	}
	
	public void setStaticArray(int index, short[] value)
	{
		this.set(index, new JSONArray(value));
	}
	
	public void setStaticArray(int index, byte[] value)
	{
		this.set(index, new JSONArray(value));
	}
	
	public void setStaticArray(int index, double[] value)
	{
		this.set(index, new JSONArray(value));
	}
	
	public void setStaticArray(int index, float[] value)
	{
		this.set(index, new JSONArray(value));
	}
	
	public void setStaticArray(int index, boolean[] value)
	{
		this.set(index, new JSONArray(value));
	}
	
	public void setStaticArray(int index, char[] value)
	{
		this.set(index, new JSONArray(value));
	}
	
	/**
	 * fetches the json array and converts back to static array. This is unoptimized only call it when needed
	 */
	public String[] getStringArray(int key)
	{
		JSONArray arr = this.getJSONArray(key);
		return JSONUtil.getStringArray(arr);
	}
	
	public long[] getLongArray(int key)
	{
		JSONArray arr = this.getJSONArray(key);
		return JSONUtil.getLongArray(arr);
	}
	
	public int[] getIntArray(int key)
	{
		JSONArray arr = this.getJSONArray(key);
		return JSONUtil.getIntArray(arr);
	}
	
	public short[] getShortArray(int key)
	{
		JSONArray arr = this.getJSONArray(key);
		return JSONUtil.getShortArray(arr);
	}
	
	public byte[] getByteArray(int key)
	{
		JSONArray arr = this.getJSONArray(key);
		return JSONUtil.getByteArray(arr);
	}
	
	public double[] getDoubleArray(int key)
	{
		JSONArray arr = this.getJSONArray(key);
		return JSONUtil.getDoubleArray(arr);
	}
	
	public float[] getFloatArray(int key)
	{
		JSONArray arr = this.getJSONArray(key);
		return JSONUtil.getFloatArray(arr);
	}
	
	public boolean[] getBooleanArray(int key)
	{
		JSONArray arr = this.getJSONArray(key);
		return JSONUtil.getBooleanArray(arr);
	}
	
	public char[] getCharArray(int key)
	{
		JSONArray arr = this.getJSONArray(key);
		return JSONUtil.getCharArray(arr);
	}
	
	/**
	 * If the value already is a {@linkplain Date}, it will be casted and returned.
	 * Otherwise the result of the value's {@link Object#toString()} will be parsed by the given
	 * {@linkplain DateFormat}. The result is returned.
	 * If the actual value is {@code null}, this method will return {@code null}.
	 * @param index index of the value
	 * @param format the {@linkplain DateFormat} used to parse the date
	 * @return a {@linkplain Date} or {@code null}
	 * @throws ParseException if the date could not be parsed
	 * @since 1.0.0
	 */
	public Date getDate(int index, DateFormat format) throws ParseException {
		return Util.getDate(this.get(index), format);
	}
	
	public void setDate(int index, Date date, DateFormat format)
	{
		this.set(index, format.format(date));
	}
	
	public void addDate(int index, Date date, DateFormat format)
	{
		this.add(index, format.format(date));
	}
	
	public boolean addDate(Date date, DateFormat format)
	{
		return this.add(format.format(date));
	}
}
