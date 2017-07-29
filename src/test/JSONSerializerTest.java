package test;

import java.time.LocalDate;

import de.ralleytn.simple.json.JSONFormatter;
import de.ralleytn.simple.json.JSONObject;
import de.ralleytn.simple.json.JSONSerializer;
import test.Person.Hobby;

public class JSONSerializerTest {

	public static void main(String[] args) throws Exception {
		
		Person person = new Person();
		person.setFirstName("Ralph");
		person.setLastName("Niemitz");
		person.setBirthDate(LocalDate.of(1998, 6, 24));
		person.setHobby(Hobby.PROGRAMMING);
		person.setMonthlyIncome(600);
		person.setFriends(new Person[] {new Person(), new Person()});
		
		JSONObject json = JSONSerializer.serialize(person);
		Person newPerson = new Person();
		JSONSerializer.deserialize(json, newPerson);
		
		System.out.println(JSONFormatter.format(JSONSerializer.serialize(newPerson).toJSONString()));
	}
}