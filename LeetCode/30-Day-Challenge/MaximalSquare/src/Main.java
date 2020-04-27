
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0)
            return 0;

        int answer = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = (matrix[i][j] - '0');
                answer = Math.max(answer, dp[i][j]);
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (dp[i][j] == 0) {
                    continue;
                }

                dp[i][j] += Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                answer = Math.max(answer, dp[i][j]);
            }
        }

        return (answer * answer);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}

