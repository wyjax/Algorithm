public class Solution {
    public int removePalindromeSub(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int left = 0;
        int right = s.length() - 1;
        char[] arr = s.toCharArray();

        while (left < right) {
            if (arr[left] != arr[right]) {
                return 2;
            }

            left++;
            right--;
        }

        return 1;
    }adgfhgfjadadadwwqweaada
}DCZÍ

/*
    ababa
 */
