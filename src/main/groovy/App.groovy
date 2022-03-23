import org.codehaus.groovy.runtime.ResourceGroovyMethods
import org.slf4j.LoggerFactory
import parser.Parser

class App {

    static def logger = LoggerFactory.getLogger(App.class)

    static void main(String[] args) {
        def content = ResourceGroovyMethods.getText(new File('./src/main/groovy/TestEnum.groovy'))
        Parser parser = new Parser()
        parser.parse(content)
    }
}
