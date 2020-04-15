
class Solution {
    public String countAndSay(int n) {
        String s = "1";

        while (n-- > 1) {
            int idx = 0;
            StringBuilder sb = new StringBuilder();

            while (idx < s.length()) {
                char c = s.charAt(idx);
                int cnt = 1;

                while (idx + cnt < s.length() && c == s.charAt(idx + cnt)) {
                    cnt++;
                }
                idx += cnt;
                sb.append(cnt + Character.toString(c));
            }
            s = sb.toString();
        }
        return s;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(4));
    }
}
