public class Main {
    public static void main(String[] args) {
        new Solution().solution(33);
    }
}
/*
13          4
33         14
 */
class Solution {
    String num = "";
    int answer = 0;

    public int solution(int number) {
        for (int i = 1; i <= number; i++) {
            num = Integer.toString(i);
            solve(num);
        }

        return answer;
    }

    public void solve(String s) {
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '3' || s.charAt(i) == '6' || s.charAt(i) == '9')
                answer++;
        }
    }
}