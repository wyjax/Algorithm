// You may use import as below.
//import java.util.*;

class Solution {
    public int solution(int n) {
        // Write code here.
        int[][] a = new int[n][n];
        int answer = 0;
        int row = 0, col = -1;
        int d = 1, maxs = n, cnt = 1;

        while (maxs >= 0) {
            for (int i = 0; i < maxs; i++) {
                col += d;
                a[row][col] = cnt++;
            }
            maxs--;

            for (int i = 0; i < maxs; i++) {
                row += d;
                a[row][col] = cnt++;
            }
            d *= -1;
        }

        for (int i = 0; i < n; i++) {
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