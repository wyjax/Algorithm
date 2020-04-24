
class Solution {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char tmp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = tmp;
        }

        for (char c : s)
            System.out.print(c);
    }
}

public class Main {
    public static void main(String[] args) {
        new Solution().reverseString();
    }
}
