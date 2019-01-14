package algo;

public class StringContainsAllLetters {
    public static void main(String[] args) {
        System.out.println(checkStringForAllLetters("Farmer jack realized that big yellow quilts were expensive"));
    }

    static boolean checkStringForAllLetters(String input) {
        int index = 0;
        boolean[] visited = new boolean[26];

        for(int id=0; id<input.length(); id++) {
            if('a' <= input.charAt(id) && input.charAt(id) <= 'z') {
                index = input.charAt(id)-'a';
            } else if ('A' <= input.charAt(id) && input.charAt(id) <= 'Z') {
                index = input.charAt(id)-'A';
            }

            visited[index] = true;
        }

        for(int id = 0; id < 26; id++) {
            if(!visited[id])
                return false;
        }

        return true;

    }

}
