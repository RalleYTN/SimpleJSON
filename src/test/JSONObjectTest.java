package test;

import java.text.ParseException;
import java.time.Month;

import de.ralleytn.simple.json.JSONObject;

public class JSONObjectTest {

	public static void main(String[] args) throws ParseException {
		
		JSONObject object = new JSONObject();
		object.put("date", "2000-01-01 01:01:00");
		object.put("month", Month.FEBRUARY);
	}
}
