import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    int[] parr = new int[26];

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        for (char c : p.toCharArray()) {
            parr[c - 'a']++;
        }

        for (int i = 0; i + p.length() <= s.length(); i++) {
            int[] sarr = new int[26];

            for (int j = 0; j < p.length(); j++) {
                sarr[s.charAt(i + j) - 'a']++;
            }

            if (Arrays.equals(sarr, parr)) {
                ans.add(i);
            }
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
