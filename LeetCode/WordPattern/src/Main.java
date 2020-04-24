import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> match = new HashMap<>();
        String[] words = str.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        int patternIdx = 0;
        while (patternIdx < pattern.length()) {
            char cur = pattern.charAt(patternIdx);

            if (match.containsKey(cur)) {
                if (!words[patternIdx].equals(match.get(cur))) {
                    return false;
                }
            }
            else {
                if (match.containsValue(words[patternIdx])) {
                    return false;
                }
                match.put(cur, words[patternIdx]);
            }
            patternIdx++;
        }

        return true;
    }

    public boolean wordPattern2(String pattern, String str) {
        HashMap<Character, String> match = new HashMap<>();
        HashSet<String> check = new HashSet<>();
        StringTokenizer st = new StringTokenizer(str);
        int idx = 0;

        while (idx < pattern.length() && st.hasMoreTokens()) {
            char cur = pattern.charAt(idx++);
            String word = st.nextToken();

            if (match.containsKey(cur)) {
                if (!word.equals(match.get(cur))) {
                    return false;
                }
            }
            else {
                if (check.contains(word)) {
                    return false;
                }
                match.put(cur, word);
                check.add(word);
            }
        }

        if (idx < pattern.length() || idx != str.split(" ").length) {
            return false;
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        new Solution().wordPattern("abba", "dog cat cat dog");
    }
}