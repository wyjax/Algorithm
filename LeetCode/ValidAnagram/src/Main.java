
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] a = new int[26];

        for (char ch : s.toCharArray()) {
            a[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            a[ch - 'a']--;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0)
                return false;
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
