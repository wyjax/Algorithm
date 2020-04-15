

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        if (haystack.length() < needle.length())
            return -1;

        int len = needle.length();
        for (int i = 0; i <= haystack.length() - len; i++) {
            String tmp = haystack.substring(i, i + len);
            if (tmp.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().strStr("hello", "ll"));
    }
}
