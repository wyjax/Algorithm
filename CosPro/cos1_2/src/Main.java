// You may use import as below.
//import java.util.*;

import java.util.Arrays;

class Solution {
    public int solution(int n) {
        // Write code here.
        int answer = 0;

        int[][] a = new int[n][n];

        int idx = 1;
        int m = n;
        int row = 0, col = 0;

        while (row < n && col < m) {
            for (int i = col; i < m; i++)
                a[row][i] = idx++;
            row++;

            for (int i = row; i < n; i++)
                a[i][m - 1] = idx++;
            m--;

            for (int i = m - 1; i >= col; i--)
                a[n - 1][i] = idx++;
            n--;
            for (int i = n - 1; i >= row; i--)
                a[i][col] = idx++;
            col++;
        }

        for (int i = 0; i < a.length; i++) {
            answer += a[i][i];
        }
        return answer;
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n1 = 3;
        int ret1 = sol.solution(n1);

        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + ret1 + " .");

        int n2 = 2;
        int ret2 = sol.solution(n2);

        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + ret2 + " .");
    }
}