

class Solution {
    int solution(int[][] land) {
        int n = land.length;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                int maxval = 0;

                // 같은 열이 아니면서 선택할 수 있는 제일 큰 값을 선택한다.
                for (int k = 0; k < 4; k++) {
                    if (j == k) continue;
                    maxval = Math.max(maxval, land[i - 1][k]);
                }
                land[i][j] += maxval;
            }
        }

        int answer = 0;
        for (int i = 0; i < 4; i++)
            answer = Math.max(answer, land[n - 1][i]);
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};
        System.out.println(new Solution().solution(a));
    }
}
