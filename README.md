[![CircleCI](https://dl.circleci.com/status-badge/img/gh/RalleYTN/SimpleJSON/tree/master.svg?style=svg)](https://dl.circleci.com/status-badge/redirect/gh/RalleYTN/SimpleJSON/tree/master)
[![CodeFactor](https://www.codefactor.io/repository/github/ralleytn/simplejson/badge/master)](https://www.codefactor.io/repository/github/ralleytn/simplejson/overview/master)
[![Coverage Status](https://coveralls.io/repos/github/RalleYTN/SimpleJSON/badge.svg?branch=master)](https://coveralls.io/github/RalleYTN/SimpleJSON?branch=master)

# Description

SimpleJSON is an improved version of [json-simple](https://github.com/fangyidong/json-simple) for Java 11+.

### Features
- [x] JSON DOM
- [x] JSON Serialization
- [x] Pretty Print
- [x] Conversion of JSON to XML
- [x] Type Safety

### Code example

Creating a JSON DOM:

```java
int[] array = {1, 2, 3, 4, 5, 6, 7};

JSONObject object = new JSONObject();
object.put("myAttribute", "myValue");
object.put("mySecondAttrib", 123456);
object.put("someArray", new JSONArray(array));

System.out.println(object.toString());
```

Parsing JSON:

```java
try {

	JSONObject object = new JSONObject(myJSONString);
	int id = object.getInteger("id");
	
	JSONArray array = new JSONArray(myJSONArrayString);
	
	for(Object element : array) {
	
		System.out.println(element);
	}

} catch(JSONParseException exception) {

	exception.printStackTrace();
}
```

## Changelog

### Version 2.1.0
<sub>NOTE: This version is incompatible with older versions of the library.</sub>

- Made the library Java 11 compatible
- Behavior of `JSONObject#compact()` has changed; the `compact` method will now also be called recursively for all child objects
- Increased unit test coverage
- Cleaned the code
- *[#7](https://github.com/RalleYTN/SimpleJSON/issues/7)*: Added new constructor to `JSONFormatter`
- *[#6](https://github.com/RalleYTN/SimpleJSON/issues/6)*: Added `JSONFormatter#format(JSONArray,Writer)`
- *[#6](https://github.com/RalleYTN/SimpleJSON/issues/6)*: Added `JSONFormatter#format(JSONObject,Writer)`
- *BUGFIX*: Fixed a typo in `JSONParseException`
- *BUGFIX*: Fixed a possible `NullPointerException` in `JSONObject#equals(Object)`
- *BUGFIX*: Fixed a possible `NullPointerException` in `JSONArray#equals(Object)`

### Version 2.0.0
<sub>NOTE: This version is incompatible with older versions of the library.</sub>

- Made the library Java 9 compatible
- `Yylex` and `Yytoken` were moved to the new `de.ralleytn.simple.json.internal` package
- Refactored `de.ralleytn.simple.json.JSONValue` to `de.ralleytn.simple.json.internal.Util`
- The `JSONFormatter` class is no longer static and its methods no longer final
- The classes `JSONSerializer`, `JSONTypeSerializationHandler`, `JSONRoot` and `JSONAttrbute` were moved to the new `de.ralleytn.simple.json.serialization` package
- Updated the documentation
- Moved the static `writeJSONString` methods to the internal `Util` class
- Renamed the non static `writeJSONString` methods to `write`
- Removed the `toJSONString` methods; use `toString` instead
- Removed the interfaces `JSONAware` and `JSONStreamAware`
- Removed the setters from the `JSONParseException` class
- Improved the performance of the Lexer
- `JSONArray` will no longer throw an exception if an object that isn't an array was given to the constructor; An empty `JSONArray` will be created instead
- `JSONObject` and `JSONArray` now override the `equals(Object)` method
- Added methods that allow for a conversion from `JSONArray` to primitive arrays
- Added `JSONUtil`
- Added unit tests
- Numbers now always get converted to `Long` when being serialized
- Deserialization will now throw an `Exception` if a setter has an interface type because interface types cannot be instantiated
- *BUGFIX*: Fixed a bug that caused the `minimize` methods to not remove `\r` characters

### Version 1.1.0

- Added `JSONObject#compact()`
- Added `JSONObject#toXML(String)`
- Added `JSONArray#toXML(String)`

### Version 1.0.0
<sub>NOTE: This is a list of changes made to [json-simple](https://github.com/fangyidong/json-simple).</sub>

- Refactored packages
- Refactored class names to include the prefix "JSON"
- Cleared a conflict with `java.text.ParseException`
- `JSONParser` now uses actual stacks
- `JSONParser` now uses `if-else` instead of `switch-case` because it is faster
- Updated the documentation
- Implemented serialization
- Implemented type safety
- Added the `JSONFormatter` class
- Added more constructors to the `JSONArray` class
- Cleaned the code
- *BUGFIX*: Fixed a bug that would not quote non-JSON type values
- *BUGFIX*: Fixed a bug that made it impossible to parse valid JSON with white spaces leading and/or trailing

## License

```
                                 Apache License
                           Version 2.0, January 2004
                        http://www.apache.org/licenses/

   TERMS AND CONDITIONS FOR USE, REPRODUCTION, AND DISTRIBUTION

   1. Definitions.

      "License" shall mean the terms and conditions for use, reproduction,
      and distribution as defined by Sections 1 through 9 of this document.

      "Licensor" shall mean the copyright owner or entity authorized by
      the copyright owner that is granting the License.

      "Legal Entity" shall mean the union of the acting entity and all
      other entities that control, are controlled by, or are under common
      control with that entity. For the purposes of this definition,
      "control" means (i) the power, direct or indirect, to cause the
      direction or management of such entity, whether by contract or
      otherwise, or (ii) ownership of fifty percent (50%) or more of the
      outstanding shares, or (iii) beneficial ownership of such entity.

      "You" (or "Your") shall mean an individual or Legal Entity
      exercising permissions granted by this License.

      "Source" form shall mean the preferred form for making modifications,
      including but not limited to software source code, documentation
      source, and configuration files.

      "Object" form shall mean any form resulting from mechanical
      transformation or translation of a Source form, including but
      not limited to compiled object code, generated documentation,
      and conversions to other media types.

      "Work" shall mean the work of authorship, whether in Source or
      Object form, made available under the License, as indicated by a
      copyright notice that is included in or attached to the work
      (an example is provided in the Appendix below).

      "Derivative Works" shall mean any work, whether in Source or Object
      form, that is based on (or derived from) the Work and for which the
      editorial revisions, annotations, elaborations, or other modifications
      represent, as a whole, an original work of authorship. For the purposes
      of this License, Derivative Works shall not include works that remain
      separable from, or merely link (or bind by name) to the interfaces of,
      the Work and Derivative Works thereof.

      "Contribution" shall mean any work of authorship, including
      the original version of the Work and any modifications or additions
      to that Work or Derivative Works thereof, that is intentionally
      submitted to Licensor for inclusion in the Work by the copyright owner
      or by an individual or Legal Entity authorized to submit on behalf of
      the copyright owner. For the purposes of this definition, "submitted"
      means any form of electronic, verbal, or written communication sent
      to the Licensor or its representatives, including but not limited to
      communication on electronic mailing lists, source code control systems,
      and issue tracking systems that are managed by, or on behalf of, the
      Licensor for the purpose of discussing and improving the Work, but
      excluding communication that is conspicuously marked or otherwise
      designated in writing by the copyright owner as "Not a Contribution."

      "Contributor" shall mean Licensor and any individual or Legal Entity
      on behalf of whom a Contribution has been received by Licensor and
      subsequently incorporated within the Work.

   2. Grant of Copyright License. Subject to the terms and conditions of
      this License, each Contributor hereby grants to You a perpetual,
      worldwide, non-exclusive, no-charge, royalty-free, irrevocable
      copyright license to reproduce, prepare Derivative Works of,
      publicly display, publicly perform, sublicense, and distribute the
      Work and such Derivative Works in Source or Object form.

   3. Grant of Patent License. Subject to the terms and conditions of
      this License, each Contributor hereby grants to You a perpetual,
      worldwide, non-exclusive, no-charge, royalty-free, irrevocable
      (except as stated in this section) patent license to make, have made,
      use, offer to sell, sell, import, and otherwise transfer the Work,
      where such license applies only to those patent claims licensable
      by such Contributor that are necessarily infringed by their
      Contribution(s) alone or by combination of their Contribution(s)
      with the Work to which such Contribution(s) was submitted. If You
      institute patent litigation against any entity (including a
      cross-claim or counterclaim in a lawsuit) alleging that the Work
      or a Contribution incorporated within the Work constitutes direct
      or contributory patent infringement, then any patent licenses
      granted to You under this License for that Work shall terminate
      as of the date such litigation is filed.

   4. Redistribution. You may reproduce and distribute copies of the
      Work or Derivative Works thereof in any medium, with or without
      modifications, and in Source or Object form, provided that You
      meet the following conditions:

      (a) You must give any other recipients of the Work or
          Derivative Works a copy of this License; and

      (b) You must cause any modified files to carry prominent notices
          stating that You changed the files; and

      (c) You must retain, in the Source form of any Derivative Works
          that You distribute, all copyright, patent, trademark, and
          attribution notices from the Source form of the Work,
          excluding those notices that do not pertain to any part of
          the Derivative Works; and

      (d) If the Work includes a "NOTICE" text file as part of its
          distribution, then any Derivative Works that You distribute must
          include a readable copy of the attribution notices contained
          within such NOTICE file, excluding those notices that do not
          pertain to any part of the Derivative Works, in at least one
          of the following places: within a NOTICE text file distributed
          as part of the Derivative Works; within the Source form or
          documentation, if provided along with the Derivative Works; or,
          within a display generated by the Derivative Works, if and
          wherever such third-party notices normally appear. The contents
          of the NOTICE file are for informational purposes only and
          do not modify the License. You may add Your own attribution
          notices within Derivative Works that You distribute, alongside
          or as an addendum to the NOTICE text from the Work, provided
          that such additional attribution notices cannot be construed
          as modifying the License.

      You may add Your own copyright statement to Your modifications and
      may provide additional or different license terms and conditions
      for use, reproduction, or distribution of Your modifications, or
      for any such Derivative Works as a whole, provided Your use,
      reproduction, and distribution of the Work otherwise complies with
      the conditions stated in this License.

   5. Submission of Contributions. Unless You explicitly state otherwise,
      any Contribution intentionally submitted for inclusion in the Work
      by You to the Licensor shall be under the terms and conditions of
      this License, without any additional terms or conditions.
      Notwithstanding the above, nothing herein shall supersede or modify
      the terms of any separate license agreement you may have executed
      with Licensor regarding such Contributions.

   6. Trademarks. This License does not grant permission to use the trade
      names, trademarks, service marks, or product names of the Licensor,
      except as required for reasonable and customary use in describing the
      origin of the Work and reproducing the content of the NOTICE file.

   7. Disclaimer of Warranty. Unless required by applicable law or
      agreed to in writing, Licensor provides the Work (and each
      Contributor provides its Contributions) on an "AS IS" BASIS,
      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
      implied, including, without limitation, any warranties or conditions
      of TITLE, NON-INFRINGEMENT, MERCHANTABILITY, or FITNESS FOR A
      PARTICULAR PURPOSE. You are solely responsible for determining the
      appropriateness of using or redistributing the Work and assume any
      risks associated with Your exercise of permissions under this License.

   8. Limitation of Liability. In no event and under no legal theory,
      whether in tort (including negligence), contract, or otherwise,
      unless required by applicable law (such as deliberate and grossly
      negligent acts) or agreed to in writing, shall any Contributor be
      liable to You for damages, including any direct, indirect, special,
      incidental, or consequential damages of any character arising as a
      result of this License or out of the use or inability to use the
      Work (including but not limited to damages for loss of goodwill,
      work stoppage, computer failure or malfunction, or any and all
      other commercial damages or losses), even if such Contributor
      has been advised of the possibility of such damages.

   9. Accepting Warranty or Additional Liability. While redistributing
      the Work or Derivative Works thereof, You may choose to offer,
      and charge a fee for, acceptance of support, warranty, indemnity,
      or other liability obligations and/or rights consistent with this
      License. However, in accepting such obligations, You may act only
      on Your own behalf and on Your sole responsibility, not on behalf
      of any other Contributor, and only if You agree to indemnify,
      defend, and hold each Contributor harmless for any liability
      incurred by, or claims asserted against, such Contributor by reason
      of your accepting any such warranty or additional liability.

   END OF TERMS AND CONDITIONS

   APPENDIX: How to apply the Apache License to your work.

      To apply the Apache License to your work, attach the following
      boilerplate notice, with the fields enclosed by brackets "{}"
      replaced with your own identifying information. (Don't include
      the brackets!)  The text should be enclosed in the appropriate
      comment syntax for the file format. We also recommend that a
      file or class name and description of purpose be included on the
      same "printed page" as the copyright notice for easier
      identification within third-party archives.

   Copyright {yyyy} {name of copyright owner}

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```

## Links

- [Original Repository](https://github.com/fangyidong/json-simple)
- [Online Documentation](https://ralleytn.github.io/SimpleJSON/)
- [Download](https://github.com/RalleYTN/SimpleJSON/releases)
- [Wiki](https://github.com/RalleYTN/SimpleJSON/wiki)
- [Java 8 Compatible Version (no longer maintained)](https://github.com/RalleYTN/SimpleJSON/tree/java8)