import java.util.HashSet;

class Solution {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> stones = new HashSet<>();
        int answer = 0;

        for (int i = 0; i < J.length(); i++) {
            if (!stones.contains(J.charAt(i)))
                stones.add(J.charAt(i));
        }
        for (int i = 0; i < S.length(); i++) {
            if (stones.contains(S.charAt(i))) {
                answer++;
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
