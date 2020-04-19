
class Solution {
    public int titleToNumber(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            int val = (s.charAt(i) - 'A') + 1;
            answer += val * Math.pow(26, s.length() - i - 1);
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().titleToNumber("AB"));
    }
}
