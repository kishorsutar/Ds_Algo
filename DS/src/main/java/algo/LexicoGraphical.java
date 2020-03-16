package algo;

public class LexicoGraphical {

    public static void main(String[] args) {
        System.out.println(nextLexicoGraphicalOrder("Kishor"));

    }

    private static String nextLexicoGraphicalOrder(String s) {
        System.out.println(s.length());
//        return s.substring(0, s.length() - 1);
        return s.substring(1);
    }
}
