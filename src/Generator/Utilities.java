package Generator;

public class Utilities {

    public static String bite(String s) {
        if (s.length() < 2) {
            return "";
        } else {
            return s.substring(1, s.length() - 1);
        }
    }
}
