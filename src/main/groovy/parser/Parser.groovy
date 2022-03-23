package parser

import org.codehaus.groovy.antlr.SourceBuffer
import org.codehaus.groovy.antlr.UnicodeEscapingReader
import org.codehaus.groovy.antlr.parser.GroovyLexer
import org.codehaus.groovy.antlr.parser.GroovyRecognizer

class Parser {

    void parse(String content) {

        SourceBuffer sourceBuffer = new SourceBuffer()
        UnicodeEscapingReader unicodeReader = new UnicodeEscapingReader(new StringReader(content), sourceBuffer)

        GroovyLexer lexer = new GroovyLexer(unicodeReader)
        unicodeReader.setLexer(lexer)
        def parser = GroovyRecognizer.make(lexer)

        parser.setSourceBuffer(sourceBuffer)
        parser.compilationUnit()
    }
}
