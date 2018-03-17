package de.ralleytn.simple.json.tests.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import de.ralleytn.simple.json.serialization.JSONAttribute;
import de.ralleytn.simple.json.serialization.JSONRoot;
import de.ralleytn.simple.json.serialization.JSONTypeSerializationHandler;

@JSONRoot
public class Person implements Serializable, JSONTypeSerializationHandler {

	private static final long serialVersionUID = -7375042144833399606L;

	private String firstName;
	private String lastName;
	private int age;
	private String city;
	private String country;
	private LocalDate birthDate;
	private List<Person> friends;
	
	@JSONAttribute(type = JSONAttribute.Type.SETTER, name = "first_name")
	public void setFirstName(String firstName) {
		
		this.firstName = firstName;
	}
	
	@JSONAttribute(type = JSONAttribute.Type.SETTER, name = "last_name")
	public void setLastName(String lastName) {
		
		this.lastName = lastName;
	}
	
	@JSONAttribute(type = JSONAttribute.Type.SETTER, name = "age")
	public void setAge(int age) {
		
		this.age = age;
	}
	
	@JSONAttribute(type = JSONAttribute.Type.SETTER, name = "city")
	public void setCity(String city) {
		
		this.city = city;
	}
	
	@JSONAttribute(type = JSONAttribute.Type.SETTER, name = "country")
	public void setCountry(String country) {
		
		this.country = country;
	}
	
	@JSONAttribute(type = JSONAttribute.Type.SETTER, name = "birth_date")
	public void setBirthDate(LocalDate birthDate) {
		
		this.birthDate = birthDate;
	}
	
	@JSONAttribute(type = JSONAttribute.Type.SETTER, name = "friends")
	public void setFriends(ArrayList<Person> friends) {
		
		this.friends = friends;
	}
	
	@JSONAttribute(type = JSONAttribute.Type.GETTER, name = "first_name")
	public String getFirstName() {
		
		return this.firstName;
	}
	
	@JSONAttribute(type = JSONAttribute.Type.GETTER, name = "last_name")
	public String getLastName() {
		
		return this.lastName;
	}
	
	@JSONAttribute(type = JSONAttribute.Type.GETTER, name = "age")
	public int getAge() {
		
		return this.age;
	}
	
	@JSONAttribute(type = JSONAttribute.Type.GETTER, name = "city")
	public String getCity() {
		
		return this.city;
	}
	
	@JSONAttribute(type = JSONAttribute.Type.GETTER, name = "country")
	public String getCountry() {
		
		return this.country;
	}
	
	@JSONAttribute(type = JSONAttribute.Type.GETTER, name = "birth_date")
	public LocalDate getBirthDate() {
		
		return this.birthDate;
	}
	
	@JSONAttribute(type = JSONAttribute.Type.GETTER, name = "friends")
	public List<Person> getFriends() {
		
		return this.friends;
	}

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
