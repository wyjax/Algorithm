import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] a = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            a[s1.charAt(i) - 'a']++;
        }

        int[] b = new int[26];
        for (int i = 0; i + s1.length() <= s2.length(); i++) {
            Arrays.fill(b, 0);

            for (int j = 0; j < s1.length(); j++) {
                b[s2.charAt(i + j) - 'a']++;
            }

            if (Arrays.equals(a, b)) {
                return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
