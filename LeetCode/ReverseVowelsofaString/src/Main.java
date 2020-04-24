
class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        if (s.length() == 0)
            return "";

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !isVowel(arr[left])) {
                left++;
            }
            while (left < right && !isVowel(arr[right])) {
                right--;
            }
            if (left >= right)
                break;

            char c = arr[left];
            arr[left] = arr[right];
            arr[right] = c;

            left++;
            right--;
        }
        return (String.valueOf(arr));
    }

    public boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseVowels("aA"));
    }
}
