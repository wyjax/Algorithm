
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alpha = new int[26];

        for (int i = 0; i < ransomNote.length(); i++) {
            alpha[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            alpha[magazine.charAt(i) - 'a']--;
        }

        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] > 0) {
                return false;
            }
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
