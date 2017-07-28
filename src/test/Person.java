package test;

import java.time.LocalDate;

import de.ralleytn.simple.json.JSONAttribute;
import de.ralleytn.simple.json.JSONRoot;

@JSONRoot
public class Person {

	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private float monthlyIncome;
	private Hobby hobby;
	private Person[] friends;
	
	@JSONAttribute(name = "first_name", type = JSONAttribute.Type.SETTER)
	public void setFirstName(String firstName) {
		
		this.firstName = firstName;
	}
	
	@JSONAttribute(name = "last_name", type = JSONAttribute.Type.SETTER)
	public void setLastName(String lastName) {
		
		this.lastName = lastName;
	}
	
	@JSONAttribute(name = "birth_date", type = JSONAttribute.Type.SETTER)
	public void setBirthDate(LocalDate birthDate) {
		
		this.birthDate = birthDate;
	}
	
	@JSONAttribute(name = "monthly_income", type = JSONAttribute.Type.SETTER)
	public void setMonthlyIncome(float monthlyIncome) {
		
		this.monthlyIncome = monthlyIncome;
	}
	
	@JSONAttribute(name = "hobby", type = JSONAttribute.Type.SETTER)
	public void setHobby(Hobby hobby) {
		
		this.hobby = hobby;
	}
	
	@JSONAttribute(name = "friends", type = JSONAttribute.Type.SETTER)
	public void setFriends(Person[] friends) {
		
		this.friends = friends;
	}
	
	@JSONAttribute(name = "first_name", type = JSONAttribute.Type.GETTER)
	public String getFirstName() {
		
		return this.firstName;
	}
	
	@JSONAttribute(name = "last_name", type = JSONAttribute.Type.GETTER)
	public String getLastName() {
		
		return this.lastName;
	}
	
	@JSONAttribute(name = "birth_date", type = JSONAttribute.Type.GETTER)
	public LocalDate getBirthDate() {
		
		return this.birthDate;
	}
	
	@JSONAttribute(name = "monthly_income", type = JSONAttribute.Type.GETTER)
	public float getMonthlyIncome() {
		
		return this.monthlyIncome;
	}
	
	@JSONAttribute(name = "hobby", type = JSONAttribute.Type.GETTER)
	public Hobby getHobby() {
		
		return this.hobby;
	}
	
	@JSONAttribute(name = "friends", type = JSONAttribute.Type.GETTER)
	public Person[] getFriends() {
		
		return this.friends;
	}
	
	public static enum Hobby {
		
		PROGRAMMING,
		GAMING,
		DRAWING,
		ANIME;
	}
}
