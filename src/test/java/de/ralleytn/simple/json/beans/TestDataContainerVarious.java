package de.ralleytn.simple.json.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import de.ralleytn.simple.json.serialization.JSONAttribute;
import de.ralleytn.simple.json.serialization.JSONRoot;

import static de.ralleytn.simple.json.TestUtil.*;

@JSONRoot
public class TestDataContainerVarious {

	@JSONAttribute(name = "string") public String string = "Hello World!";
	@JSONAttribute(name = "stringNull") public String stringNull = null;
	@JSONAttribute(name = "bTrue") public boolean bTrue = true;
	@JSONAttribute(name = "bFalse") public boolean bFalse = false;
	@JSONAttribute(name = "bTrueInstance") public Boolean bTrueInstance = true;
	@JSONAttribute(name = "bFalseInstance") public Boolean bFalseInstance = false;
	@JSONAttribute(name = "bNullInstance") public Boolean bNullInstance = null;
	@JSONAttribute(name = "person") public TestPersonWithPublicFields person = new TestPersonWithPublicFields();
	@JSONAttribute(name = "vByte") public byte vByte = 9;
	@JSONAttribute(name = "vShort") public short vShort = 10;
	@JSONAttribute(name = "vInt") public int vInt = 11;
	@JSONAttribute(name = "vLong") public long vLong = 12;
	@JSONAttribute(name = "vFloat") public float vFloat = 13.3F;
	@JSONAttribute(name = "vDouble") public double vDouble = 14.4;
	@JSONAttribute(name = "map") public HashMap<Object, Object> map = createObject();
	@JSONAttribute(name = "collection") public ArrayList<Object> collection = createStringArray();
	@JSONAttribute(name = "date") public Date date = new Date(0);
	@JSONAttribute(name = "iByte") public Byte iByte = 15;
	@JSONAttribute(name = "iShort") public Short iShort = 16;
	@JSONAttribute(name = "iInt") public Integer iInt = 17;
	@JSONAttribute(name = "iLong") public Long iLong = 18L;
	@JSONAttribute(name = "iFloat") public Float iFloat = 19.9F;
	@JSONAttribute(name = "iDouble") public Double iDouble = 20.5;
	@JSONAttribute(name = "iByteNull") public Byte iByteNull = null;
	@JSONAttribute(name = "iShortNull") public Short iShortNull = null;
	@JSONAttribute(name = "iIntNull") public Integer iIntNull = null;
	@JSONAttribute(name = "iLongNull") public Long iLongNull = null;
	@JSONAttribute(name = "iFloatNull") public Float iFloatNull = null;
	@JSONAttribute(name = "iDoubleNull") public Double iDoubleNull = null;
	@JSONAttribute(name = "vEnum") public TestEnum vEnum = TestEnum.TEST5;
	@JSONAttribute(name = "vEnumNull") public TestEnum vEnumNull = null;
	@JSONAttribute(name = "map2") public HashMap<Object, Object> map2 = createObjectWithAllPossibleTypes(this.date);
	
	public TestDataContainerVarious empty() {
		
		this.string = null;
		this.bTrue = false;
		this.bTrueInstance = null;
		this.bFalseInstance = null;
		this.person = null;
		this.vByte = 0;
		this.vShort = 0;
		this.vInt = 0;
		this.vLong = 0;
		this.vFloat = 0;
		this.vDouble = 0;
		this.map = null;
		this.collection = null;
		this.date = null;
		this.iByte = null;
		this.iShort = null;
		this.iInt = null;
		this.iLong = null;
		this.iFloat = null;
		this.iDouble = null;
		this.vEnum = null;
		this.map2 = null;
		
		return this;
	}
}
