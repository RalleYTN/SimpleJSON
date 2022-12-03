package de.ralleytn.simple.json.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import de.ralleytn.simple.json.serialization.JSONAttribute;
import de.ralleytn.simple.json.serialization.JSONRoot;
import de.ralleytn.simple.json.serialization.JSONTypeSerializationHandler;

@JSONRoot
public class TestPersonWithPublicFields implements Serializable, JSONTypeSerializationHandler {

	private static final long serialVersionUID = 7615961222098820673L;
	
	@JSONAttribute(name = "first_name") 	public String firstName;
	@JSONAttribute(name = "last_name") 		public String lastName;
	@JSONAttribute(name = "age") 			public int age;
	@JSONAttribute(name = "city") 			public String city;
	@JSONAttribute(name = "country") 		public String country;
	@JSONAttribute(name = "birth_date") 	public LocalDate birthDate;
	@JSONAttribute(name = "friends") 		public List<TestPersonWithPublicFields> friends;
	@JSONAttribute(name = "blood_donor") 	public transient boolean bloodDonor;
	
	public String gender;
	
	@JSONAttribute(name = "postal_code", type = JSONAttribute.Type.SETTER)
	public String postalCode;
	
	@Override
	public Object serialize(Class<?> type, Object value) {
		
		if(LocalDate.class.equals(type) && value != null) {
			
			return value.toString();
		}
		
		return null;
	}

	@Override
	public Object deserialize(Class<?> type, Object value) {
		
		if(LocalDate.class.equals(type) && value != null) {
			
			return LocalDate.parse(value.toString());
		}
		
		return null;
	}
}
