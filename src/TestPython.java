import java.io.IOException;

public class TestPython {
    public static void main(String[] args) {
        try {
            PythonLexer lexer = new PythonLexer("lambda x, y, z : x * (y - 2 + 421) * 213554 / z");
            PythonParser parser = new PythonParser(lexer.tokenize());
            PythonParser.sContext s = parser.s();
            System.out.println("OK");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
