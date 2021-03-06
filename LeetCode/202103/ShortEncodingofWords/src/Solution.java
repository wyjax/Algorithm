import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public static int minimumLengthEncoding(String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));

        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                wordSet.remove(word.substring(i));
            }
        }

        int ans = 0;

        for (String word : wordSet) {
            ans += word.length() + 1;
        }

        return ans;
    }
}
