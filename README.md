# GradleReproducer
test project for gradle team

We recently upgraded to gradle version 7.4.1 and ran into problem with parsing groovy enums.

Environment:

- Java SDK 11
- Gradle 7.4.1
- Groovy 2.5.15

We try parse groovy enums using GroovyRecognizer. Groovy code:

```
SourceBuffer sourceBuffer = new SourceBuffer()
UnicodeEscapingReader unicodeReader = new UnicodeEscapingReader(new StringReader(‘ExampleEnum.groovy'), sourceBuffer)
GroovyLexer lexer = new GroovyLexer(unicodeReader)
unicodeReader.setLexer(lexer)
parser = GroovyRecognizer.make(lexer)
parser.setSourceBuffer(sourceBuffer)
parser.compilationUnit()
```

Enum example:

```
@API
public enum ExampleEnum implements Serializable {
	@API
	ITEM1(1),
	@API
	ITEM2(2),
	@API
	ITEM3(3);
	
	private Integer value;

	public TaggableClasses(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return this.value;
}	
```

.compilationUnit() method throws an exception "Parsing failed for 'ExampleEnum.groovy' due to: unexpected token: 2"
Token is value of ITEM2.

Groovy class and interfaces parsing work correctly.
