import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        int cnt = progresses.length;
        int idx = 0;

        while (cnt > 0) {
            for (int i = idx; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }

            if (progresses[idx] >= 100) {
                int tmp = 1;
                cnt--;

                for(int j = idx + 1; j < progresses.length; j++) {
                    if (progresses[j] < 100) {
                        idx = j;
                        break;
                    }
                    cnt--;
                    tmp++;
                }

                list.add(tmp);
            }
        }

        int answer[] = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}

public class Good {
    public static void main(String []args) {
        int a[] = {40, 93, 30, 55, 60, 65};
        int b[] = {60, 1, 30, 5 , 10, 7};
        new Solution().solution(a, b);
    }
}
