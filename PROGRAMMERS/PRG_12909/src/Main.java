

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                sum++;
            else
                sum--;

            if (sum < 0) {
                answer = false;
                break;
            }
        }
        if (sum != 0)
            answer = false;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
