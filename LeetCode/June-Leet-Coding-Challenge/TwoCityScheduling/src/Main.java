import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int N = costs.length / 2;
        int[] refund = new int[N * 2];
        int minCost = 0, index = 0;


        // 2N개 만큼 더해준다.
        for (int[] cost : costs) {
            refund[index++] = cost[1] - cost[0];
            // 더해줌
            minCost += cost[0];
        }
        // 정렬하면 cost[1]의 값이 더 컸을 때 순으로 가져옴
        Arrays.sort(refund);
        for (int i = 0; i < N; i++) {
            // 환불해준다.
            minCost += refund[i];
        }
        return minCost;
    }

    public int twoCitySchedCost2(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] - o1[1]) - (o2[0] - o2[1]);
            }
        });

        int total = 0;
        int n = costs.length/2;

        for(int i = 0; i<n; ++i) {
            total += costs[i][0] + costs[i+n][1];
        }

        return total;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
