

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        long left = 0;
        long right = 0;
        long mid;

        for (int time : times) {
            // 심사시간 중에 최대값 찾는다
            right = Math.max(time, right);
        }
        // 심사하는데 걸리는 최대 시간
        right *= n;

        // 시간으로 타협점을 찾는다.
        while (left <= right) {
            long done = 0;
            mid = (left + right) / 2;

            // 예상시간을 먼저 정하고 각 심사위원이 해결할 수 있는 사람수를 구해서 done에 더한다.
            for (int time : times)
                done += (mid / time);
            // 예상시간으로 해결이 불가능할 경우
            if (done < n)
                left = mid + 1;
            // 에상시간으로 해결이 가능한 경우
            else {
                answer = Math.min(answer, mid);
                right = mid - 1;
            }
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] a = {7, 10};
        System.out.println(new Solution().solution(6, a));
    }
}
