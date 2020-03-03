class Solution {

    public int solution(int n, int[][] costs) {
        int answer = 0;
        boolean[] visit = new boolean[n];
        boolean[] bridge = new boolean[costs.length];
        visit[costs[0][0]] = true;
        visit[costs[0][1]] = true;
        bridge[0] = true;
        answer = costs[0][2];

        for (int i = 1; i < costs.length; i++) {
            if (bridge[i]) continue;
            if ((!visit[costs[i][0]] && visit[costs[i][1]]) || (visit[costs[i][0]] && !visit[costs[i][1]])) {
                visit[costs[i][0]] = true;
                visit[costs[i][1]] = true;
                bridge[i] = true;

                answer += costs[i][2];
            }
        }
        System.out.println(answer);

        return answer;
    }

    public static void main(String[] args) {
        int[][] answer = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
        new Solution().solution(5, answer);
    }
}