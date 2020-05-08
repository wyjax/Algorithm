
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] a = new int[n + 1][m + 1];
        int[][] d = new int[n + 1][m + 1];

        for (int i = 0; i < puddles.length; i++) {
            a[puddles[i][1]][puddles[i][0]] = -1;
        }
        d[1][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i][j] == -1)
                    d[i][j] = 0;
                else
                    d[i][j] = (d[i - 1][j] + d[i][j - 1]) % 1000000007;
            }
        }
        return d[n][m];
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] a = {{2, 2}};
        System.out.println(new Solution().solution(4, 3, a));
    }
}
