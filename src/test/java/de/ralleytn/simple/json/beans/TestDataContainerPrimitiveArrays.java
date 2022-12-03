package de.ralleytn.simple.json.beans;

import de.ralleytn.simple.json.serialization.JSONAttribute;
import de.ralleytn.simple.json.serialization.JSONRoot;

import static de.ralleytn.simple.json.TestUtil.*;

import java.util.Arrays;

@JSONRoot
public class TestDataContainerPrimitiveArrays {

	@JSONAttribute(name = "bytes") public byte[] bytes = PRIMITIVE_BYTES;
	@JSONAttribute(name = "shorts") public short[] shorts = PRIMITIVE_SHORTS;
	@JSONAttribute(name = "ints") public int[] ints = PRIMITIVE_INTS;
	@JSONAttribute(name = "longs") public long[] longs = PRIMITIVE_LONGS;
	@JSONAttribute(name = "floats") public float[] floats = PRIMITIVE_FLOATS;
	@JSONAttribute(name = "doubles") public double[] doubles = PRIMITIVE_DOUBLES;
	@JSONAttribute(name = "booleans") public boolean[] booleans = PRIMITIVE_BOOLEANS;
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof TestDataContainerPrimitiveArrays) {
			
			TestDataContainerPrimitiveArrays other = (TestDataContainerPrimitiveArrays)obj;

			return Arrays.equals(this.booleans, other.booleans) &&
				   Arrays.equals(this.bytes, other.bytes) &&
				   Arrays.equals(this.shorts, other.shorts) &&
				   Arrays.equals(this.ints, other.ints) &&
				   Arrays.equals(this.longs, other.longs) &&
				   Arrays.equals(this.floats, other.floats) &&
				   Arrays.equals(this.doubles, other.doubles);
		}
		
		return false;
	}
	
	public TestDataContainerPrimitiveArrays empty() {
		
		this.bytes = null;
		this.shorts = null;
		this.ints = null;
		this.longs = null;
		this.floats = null;
		this.doubles = null;
		this.booleans = null;
		
		return this;
	}
}
