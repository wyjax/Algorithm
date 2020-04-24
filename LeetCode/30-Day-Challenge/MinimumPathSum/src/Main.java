class Solution {
    int[] dx = {1, 0};
    int[] dy = {0, 1};

    public int minPathSum(int[][] grid) {
        if (grid.length == 0)
            return 0;

        int n = grid.length;
        int m = grid[0].length;
        int[][] pathSum = new int[n][m];
        pathSum[0][0] = grid[0][0];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 2; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx >= n || ny >= m) continue;
                    int tmpSum = pathSum[i][j] + grid[nx][ny];
                    if (pathSum[nx][ny] == 0) {
                        pathSum[nx][ny] = tmpSum;
                    }
                    else {
                        pathSum[nx][ny] = Math.min(pathSum[nx][ny], tmpSum);
                }
            }
        }
        return pathSum[n - 1][m - 1];
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] a = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(new Solution().minPathSum(a));
    }
}
