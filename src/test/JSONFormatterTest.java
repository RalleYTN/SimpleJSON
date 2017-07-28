package test;

import de.ralleytn.simple.json.JSONFormatter;

public class JSONFormatterTest {

	public static void main(String[] args) {
		
		// MINIMIZE
		String json = "{\n\t\"testValue1\":\"Hello there!\",\n    \"testValue2\":300,\n\"testValue3\":{}}";
		System.out.println("==== ORIGINAL ====");
		System.out.println(json);
		String minimized = JSONFormatter.minimize(json);
		System.out.println();
		System.out.println("==== MINIMIZED ====");
		System.out.println(minimized);
		System.out.println();
		System.out.println("==== FORMATTED ====");
		System.out.println(JSONFormatter.format(minimized));
	}
}
