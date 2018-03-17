package de.ralleytn.simple.json.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import org.junit.jupiter.api.Test;

import de.ralleytn.simple.json.JSONFormatter;

/**
 * Tests the {@linkplain JSONFormatter} class.
 * @author Ralph Niemitz/RalleYTN(ralph.niemitz@gmx.de)
 * @version 2.0.0
 * @since 2.0.0
 */
class JSONFormatterTest {

	private static final void testMinimize(String formatted, String message) {
		
		// Test minimize(String)
		assertEquals(TestUtil.JSON_MINIMIZED, new JSONFormatter().minimize(formatted));
		
		// Test minimize(Reader,Writer)
		try(StringReader reader = new StringReader(formatted)) {
			
			try(StringWriter writer = new StringWriter()) {
				
				new JSONFormatter().minimize(reader, writer);
				assertEquals(TestUtil.JSON_MINIMIZED, writer.toString(), message);
				
			} catch(IOException exception) {
				
				fail(exception);
			}
		}
	}
	
	private static final void printError(String expected, String result) {
		
		for(int index = 0; index < (result.length() < expected.length() ? result.length() : expected.length()); index++) {
			
			if(result.charAt(index) != expected.charAt(index)) {
				
				System.err.println("The expected result and the actual result are unqual at index " + index + "!");
				System.err.println(result.substring(0, result.length() - index + 1));
			}
		}
	}
	
	private static final void testFormat(String expected, String message, boolean crlf, boolean tabs, int indent) {
		
		// Test the JSONFormatter setters and getters
		JSONFormatter formatter = new JSONFormatter();
		formatter.setIndent(indent);
		formatter.setUseCRLF(crlf);
		formatter.setUseTabs(tabs);
		
		assertEquals(indent, formatter.getIndent(), "Either setIndent(int) or getIndent() doesn't work!");
		assertEquals(crlf, formatter.usesCRLF(), "Either setUseCRLF(boolean) or usesCRLF() doesn't work!");
		assertEquals(tabs, formatter.usesTabs(), "Either setUseTabs(boolean) or usesTabs() doesn't work!");
		
		// Test format(String)
		String result = formatter.format(TestUtil.JSON_MINIMIZED);
		printError(expected, result);
		assertEquals(expected, result, message);
		
		// Test format(Reader,Writer)
		try(StringReader reader = new StringReader(TestUtil.JSON_MINIMIZED)) {
			
			try(StringWriter writer = new StringWriter()) {
				
				formatter.format(reader, writer);
				result = writer.toString();
				printError(expected, result);
				assertEquals(expected, result, message);
				
			} catch(IOException exception) {
				
				fail(exception);
			}
		}
	}
	
	/**
	 * Tests if the formatting of JSON data works.
	 * @since 1.0.0
	 */
	@Test
	public void testFormat() {

		testFormat(TestUtil.JSON_FORMATTED_NORMAL, "JSON_FORMATTED_NORMAL", false, true, 1);
		testFormat(TestUtil.JSON_FORMATTED_CRLF, "JSON_FORMATTED_CRLF", true, true, 1);
		testFormat(TestUtil.JSON_FORMATTED_I2, "JSON_FORMATTED_I2", false, true, 2);
		testFormat(TestUtil.JSON_FORMATTED_SPACE, "JSON_FORMATTED_SPACE", false, false, 1);
		testFormat(TestUtil.JSON_FORMATTED_SPACE_I2, "JSON_FORMATTED_SPACE_I2", false, false, 2);
		testFormat(TestUtil.JSON_FORMATTED_SPACE_CRLF, "JSON_FORMATTED_SPACE_CRLF", true, false, 1);
		testFormat(TestUtil.JSON_FORMATTED_SPACE_CRLF_I2, "JSON_FORMATTED_SPACE_CRLF_I2", true, false, 2);
	}
	
	/**
	 * Tests if the minimizing of JSON data works.
	 * @since 2.0.0
	 */
	@Test
	public void testMinimize() {
		
		testMinimize(TestUtil.JSON_FORMATTED_NORMAL, "JSON_FORMATTED_NORMAL");
		testMinimize(TestUtil.JSON_FORMATTED_CRLF, "JSON_FORMATTED_CRLF");
		testMinimize(TestUtil.JSON_FORMATTED_I2, "JSON_FORMATTED_I2");
		testMinimize(TestUtil.JSON_FORMATTED_SPACE, "JSON_FORMATTED_SPACE");
		testMinimize(TestUtil.JSON_FORMATTED_SPACE_I2, "JSON_FORMATTED_SPACE_I2");
		testMinimize(TestUtil.JSON_FORMATTED_SPACE_CRLF, "JSON_FORMATTED_SPACE_CRLF");
		testMinimize(TestUtil.JSON_FORMATTED_SPACE_CRLF_I2, "JSON_FORMATTED_SPACE_CRLF_I2");
	}
}
