import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        Calculator calculator = new Calculator("5+10/(2-4)*2");
        Integer x = calculator.e().res;
        System.out.println(x);
    }
}
