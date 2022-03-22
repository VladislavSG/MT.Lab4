import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestCalculator {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String line = reader.readLine();
                if (line.equals("exit")) break;
                try {
                    CalculatorLexer lexer = new CalculatorLexer(line);
                    CalculatorParser parser = new CalculatorParser(lexer.tokenize());
                    Integer res = parser.e().res;
                    System.out.println(res);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
//
    }
}
