
// 나눗셈을 이용하여 처리
class Solution {
    boolean answer = true;
    public boolean solution(int x) {
        int sum = 0;
        int tmp = x;

        int div = 10000;
        while (tmp > 0) {
            sum += tmp / div;
            tmp %= div;
            div /= 10;
        }

        if (x % sum > 0)
            answer = false;

        return answer;
    }
}

/*

// 문자열로 처리
class Solution {
    public boolean solution(int x) {
        boolean answer = true;

        String s = Integer.toString(x);

        int sum = 0;
        for(int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
        }
        if (x % sum != 0)
            answer = false;

        return answer;
    }
}
*/

public class Main {
    public static void main(String[] args) {

    }
}