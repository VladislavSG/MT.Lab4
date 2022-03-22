import java.io.IOException;
import java.util.List;

public class TestPython {
    public static void main(String[] args) {
        try {
            List<Integer> tokens = new PythonLexer("lambda x, x, x, x : x * (x - 2 + 421) * 213554".replaceAll(" ", "")).tokenize();
            PythonParser parser = new PythonParser(tokens);
            PythonParser.sContext s = parser.s();
            System.out.println("OK");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
