package Generator;

public class Utilities {

    public static String bite(String s) {
        return bite(s, 1, 1);
    }

    public static String bite(String s, int l, int r) {
        if (s.length() < l + r) {
            return "";
        } else {
            return s.substring(l, s.length() - r);
        }
    }
}
