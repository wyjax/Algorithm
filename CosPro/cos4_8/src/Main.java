// 다음과 같이 import를 사용할 수 있습니다.

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    int[] count;
    ArrayList<Integer> list;

    public int solution(int[] card, int n) {
        // 여기에 코드를 작성해주세요.
        count =new int[10];
        list = new ArrayList<>();
        for (int i = 0; i < card.length; i++)
            count[card[i]]++;
        Arrays.sort(card);
        search(0, 0, card);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == n)
                return i + 1;
        }
        return -1;
    }

    public void search(int cnt, int num, int[] card) {
        if (cnt == card.length) {
            System.out.println(num);
            list.add(num);
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (count[i] > 0) {
                count[i]--;
                search(cnt + 1, num * 10 + i, card);
                count[i]++;
            }
        }
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution sol = new Solution();
        int card1[] = {1, 2, 1, 3};
        int n1 = 1312;
        int ret1 = sol.solution(card1, n1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int card2[] = {1, 1, 1, 2};
        int n2 = 1122;
        int ret2 = sol.solution(card2, n2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}