import java.util.HashMap;
import java.util.LinkedHashMap;

class Solution {

    // 23 ms
    public int firstUniqChar2(String s) {
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        int answer = -1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (map.get(ch) == 1) {
                answer = i;
                break;
            }
        }
        return answer;
    }

    // 7 ms
    public int firstUniqChar(String s) {
        int[] alpha = new int[26];
        int answer = -1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            alpha[ch - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (alpha[ch - 'a'] == 1) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
