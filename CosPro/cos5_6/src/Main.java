// 다음과 같이 import를 사용할 수 있습니다.

class Solution {
    public String solution(String s1, String s2, int p, int q) {
        // 여기에 코드를 작성해주세요.

        int a = toDecimal(s1, p);
        int b = toDecimal(s2, p);
        String answer = toQ(a + b, q);

        return answer;
    }

    public String toQ(int sum, int q) {
        String ret = "";
        while (sum >= q) {
            ret = Integer.toString(sum % q) + ret;
            sum /= q;
        }
        ret = sum + ret;

        return ret;
    }

    public int toDecimal(String s, int p) {
        int ret = 0;
        int val = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            ret += val * (s.charAt(i) - '0');
            val *= p;
        }
        return ret;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.	
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s1 = new String("112001");
        String s2 = new String("12010");
        int p = 3;
        int q = 8;
        String ret = sol.solution(s1, s2, p, q);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}