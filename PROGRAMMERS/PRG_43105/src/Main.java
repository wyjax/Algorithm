

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] d = new int[triangle.length][triangle[triangle.length - 1].length];

        for (int i = 0; i < d[0].length; i++)
            d[0][i] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j > 0)
                    d[i][j] = triangle[i][j] + d[i - 1][j - 1];
                if (j + 1 < triangle[i].length)
                    d[i][j] = Math.max(d[i][j], triangle[i][j] + d[i - 1][j]);
            }
        }

        for (int i = 0; i < d[0].length; i++) {
            answer = Math.max(answer, d[d.length - 1][i]);
        }
        return answer;
}
}

public class Main {
    public static void main(String[] args) {
        int[][] a = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(new Solution().solution(a));
    }
}
