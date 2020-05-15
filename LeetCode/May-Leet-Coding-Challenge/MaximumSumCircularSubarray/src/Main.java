
class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int curMin = 0;
        int curMax = 0;
        int total = 0;

        for (int num : A) {
            total += num;

            curMin += num;
            min = Math.min(min, curMin);
            // 0보다 큰 값이 되면 더이상 최솟값을 만들 수기 없음
            curMin = Math.min(curMin, 0);

            curMax += num;
            max = Math.max(max, curMax);
            // 0보다 작은 값이 되면 더이상 최대값을 만들 수가 없음
            curMax = Math.max(curMax, 0);
        }

        return ((max < 0) ? max : Math.max(max, total - min));
    }
}

public class Main {
    public static void main(String[] args) {

    }
}

/*
    솔루션 생각
        [3, -1, 2, -1]

        3 + (-1) + 2 = 4 >> answer

 */