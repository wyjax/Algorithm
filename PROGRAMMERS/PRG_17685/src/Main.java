import java.util.Arrays;

class Solution {
    public int solution(String[] words) {
        int answer = 0;
        Arrays.sort(words);

        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                answer += sol(words[i + 1], words[i]);
            }
            else if (i == words.length - 1) {
                answer += sol(words[i - 1], words[i]);
            }
            else {
                int ans1 = sol(words[i + 1], words[i]);
                int ans2 = sol(words[i - 1], words[i]);
                answer += Math.max(ans1, ans2);
            }
        }
        return answer;
    }

    public int sol(String start, String mid) {
        int len = Math.min(start.length(), mid.length());
        for (int i = 0; i < len; i++) {
            if (start.charAt(i) != mid.charAt(i))
                return i + 1;
        }
        if (start.length() < mid.length())
            return start.length() + 1;
        else
            return len;
    }
}

public class Main {
    public static void main(String[] args) {
        String[] s = {"go", "gone", "guild"};
        String[] s2 = {"abc", "def", "ghi", "jklm"};
        String[] s3 = {"word", "war", "warrior", "world"};
        String[] s4 = {"a", "ab", "abc"};
        String[] s5 = {"a", "abc", "abcde"};
        System.out.println(new Solution().solution(s5));
    }
}