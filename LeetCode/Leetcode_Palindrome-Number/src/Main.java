
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        String s = Integer.toString(x);
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(10));
    }
}
