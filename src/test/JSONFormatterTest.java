package test;

import de.ralleytn.simple.json.JSONFormatter;

public class JSONFormatterTest {

	public static void main(String[] args) {
		
		// MINIMIZE
		String json = "{\n\t\"testValue1\":\"Hello there!\",\n    \"testValue2\":300\n}";
		System.out.println(json);
		System.out.println(JSONFormatter.minimize(json));
	}
}
