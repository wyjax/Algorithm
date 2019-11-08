public class Main {
    public static void main(String[] args) {
        new Solution().solution("browoanoommnaon");
    }
}

class Solution {
    String s;

    public String solution(String input) {
        this.s = input;
        boolean exit;

        while (true) {
            exit = solve();

            if (exit)
                break;
        }

        return s;
    }

    public boolean solve() {
        boolean result = true;
        StringBuilder sb = new StringBuilder("");

        for(int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1) {
                sb.append(s.charAt(i));
                continue;
            }
            else if (s.charAt(i) != s.charAt(i + 1)) {
                sb.append(s.charAt(i));
                continue;
            }

            result = false;
            char c = s.charAt(i);
            int j = i + 1;
            for(; j < s.length(); j++) {
                if (c != s.charAt(j))
                    break;
            }
            i = j - 1;
        }
        s = sb.toString();
        return result;
    }
}