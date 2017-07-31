# Description

SimpleJSON is an improved version of [json-simple](https://github.com/fangyidong/json-simple).
It adds type safety, serialization, tidy formatting and improved performance.

# Why use this library over the original?

Because the original was made for Java 2. A version of Java where things like generics weren't there yet. That causes code written with the original library to be completly type unsafe.
It was a casting hell. And on top of that, you could not serialize and deserialize objects.

# Features

- [x] type safe JSON parsing
- [x] parsing JSON with a stoppable SAX like content handler
- [x] serializing and deserializing
- [x] formatting and minimizing JSON data
- [x] light weight JSON writing
- [x] a `JSONObject` and `JSONArray` class allowing for reading and writing of JSON data even without serializing

# Requirements

- Java 8 or higher

# Short Example

JSON:
```json
{
	"first_name":"John",
	"last_name":"Doe",
	"income":1200.0,
	"friends": [
		{
			"first_name":"Jane",
			"last_name":"Doe",
			"income":1000.0,
			"friends": [
				"John|Doe"
			]
		}
	]
}
```

Java:
```java
try {

	String myJSONData = "<Insert code from above>";
	JSONObject object = new JSONObject(myJSONData);
	String firstName = object.getString("first_name");
	String friendsFirstName = object.getArray("friends").getObject(0).getString("first_name");
	float income = object.getFloat("income");

} catch(JSONParseException exception) {

	exception.printStackTrace();
}
```

# Setup

Just put the Java archive on your project's class path.

# Changelog

- Version 1.0.0
	- Release

# List of changes made to the original library

This list only applies to version 1.0.0 of this library!


- The packages of the original are merged into one
- All public classes now have `JSON` in front of their name. This makes it easier to tell which classes come from that library. Also clears a conflict with the `java.text.ParseException`.
- The `JSONParser` now uses actual stacks
- The `JSONParser` now uses `if-else` instead of `switch-case` because it is faster.
- Updated the documentation.
- Fixed a bug that made it impossible to parse valid JSON with white spaces leading and/or trailing.
- Made it possible to serialize and deserialize JSON
- Added the `JSONFormatter` class which makes it possible to format minimized or minimize formatted JSON data.
- Added more constructors to the `JSONArray` class
- Added constructors to the `JSONObject` and `JSONArray` class which allows direct and type safe parsing of JSON data.
- Added getter methods to `JSONObject` and `JSONArray` which allow type safe reading of data.
- Deleted all unneeded and deprecated methods.
- Fixed a bug that would not quote non-JSON type values.

# Links
See the [original](https://github.com/fangyidong/json-simple)    
See the [online documentation](https://ralleytn.github.io/SimpleJSON/)    
See the [changelog](https://github.com/RalleYTN/SimpleJSON/blob/master/CHANGELOG.md)    
See the [download page](https://github.com/RalleYTN/SimpleJSON/releases)    
See the [complete guide](https://github.com/RalleYTN/SimpleJSON/wiki) on how to use the library