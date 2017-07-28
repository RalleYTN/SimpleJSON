package test;

import java.time.LocalDateTime;

import de.ralleytn.simple.json.JSONObject;

public class JSONObjectTest {

	public static void main(String[] args) {
		
		JSONObject object = new JSONObject();
		object.put("date", "2000-01-01 01:01:00");
		System.out.println(object.getLocalDateTime("date"));
	}
}
