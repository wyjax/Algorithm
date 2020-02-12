// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class Solution {
    public int solution(int[] arr) {
        // 여기에 코드를 작성해주세요.
        int answer = 0;
        int[] d = new int[arr.length];
        Arrays.fill(d, 1);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i])
                d[i] += d[i - 1];
        }

        for (int num : d)
            answer = answer < num ? num : answer;

        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {3, 1, 2, 4, 5, 1, 2, 2, 3, 4, 6, 8, 3, 2, 5, 7, 4, 3, 2, 3, 4, 5, 7, 8, 23};
        int ret = sol.solution(arr);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}