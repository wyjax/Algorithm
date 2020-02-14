// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class Solution {
    public int solution(int[] arr, int K) {
        // 여기에 코드를 작성해주세요.
        int answer = -1;
        Arrays.sort(arr);
        // 4 6 9 9 11 19
        for (int i = 0; i + K < arr.length; i++) {
            int tmp = arr[i + 3] - arr[i];
            if (answer == -1 || answer > tmp)
                answer = tmp;
        }

        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {9, 11, 9, 6, 4, 19, 8, 10};
        int K = 4;
        int ret = sol.solution(arr, K);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + "입니다.");
    }
}