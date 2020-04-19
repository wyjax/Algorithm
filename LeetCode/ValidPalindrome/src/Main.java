class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();

        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            boolean check = true;

            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
                check = false;
            }
            if (!Character.isLetterOrDigit(rightChar)) {
                right--;
                check = false;
            }

            if (check) {
                if (leftChar != rightChar) {
                    return false;
                }
                else {
                    left++;
                    right--;
                }
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new Solution().isPalindrome("race a car"));
    }
}


/*

    A man, a plan, a canal: Panama
    a man  a planac a nalp a nam a
    ra ce ac ar
 */