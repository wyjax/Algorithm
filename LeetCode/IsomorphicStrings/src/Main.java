import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> sConvert = new HashMap<>();
        HashSet<Character> tConvert = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ts = t.charAt(i);

            if (sConvert.containsKey(cs)) {
                if (sConvert.get(cs) != ts) {
                    return false;
                }
            }
            else {
                if (tConvert.contains(ts)) {
                    return false;
                }
                sConvert.put(cs, ts);
                tConvert.add(ts);
            }
        }

        return true;
    }
}

/*
    abab
    baba
 */

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isIsomorphic("ab", "ca"));
    }
}
