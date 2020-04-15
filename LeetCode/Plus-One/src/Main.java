class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0)
            return new int[1];

        int carry = 0;
        digits[digits.length - 1]++;

        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] %= 10;
        }

        if (carry == 0)
            return digits;
        else {
            int[] answer = new int[digits.length + 1];
            for (int i = 0; i < digits.length; i++) {
                answer[i + 1] = digits[i];
            }
            answer[0] = carry;
            return answer;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] a = {7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 6};
        int[] b = {9};
        System.out.println(new Solution().plusOne(b));
    }
}
