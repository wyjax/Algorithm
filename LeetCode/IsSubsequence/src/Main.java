
class Solution {
    public boolean isSubsequence(String s, String t) {
        int idx = 0;

        for (int i = 0; idx < s.length() && i < t.length(); i++) {
            if (s.charAt(idx) == t.charAt(i)) {
                idx++;
            }
        }

        if (idx == s.length()) {
            return true;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
