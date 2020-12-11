package ds.arraystring;

public class CeaserCipher {

    public static void main(String[] args) {
        ceaserCepher("jahdfkjf", 45);
    }

    static void ceaserCepher(String s, int k) {
        int base = 'a';



        for (char c : s.toCharArray()) {

            int value = ((c + k - base) % 26 + base);
            System.out.println("Value " + (char) value);
        }

    }
}
