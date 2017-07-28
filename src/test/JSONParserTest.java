package test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import de.ralleytn.simple.json.JSONArray;
import de.ralleytn.simple.json.parser.JSONParser;
import de.ralleytn.simple.json.parser.ParseException;

public class JSONParserTest {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		JSONArray array = (JSONArray)parser.parse(new FileReader("test1.json"));
		System.out.println(array);
	}
}
