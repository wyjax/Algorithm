
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String obj = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(obj)) {
                obj = obj.substring(0, obj.length() - 1);
            }
        }
        return obj;
    }
}

public class Main {
    public static void main(String[] args) {
        String[] s = {"a", "b"};
        String[] s2 = {"flower", "flow", "flight"};
        System.out.println(new Solution().longestCommonPrefix(s));
    }
}
