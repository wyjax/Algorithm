// You may use import as below.
//import java.util.*;

import com.sun.org.apache.xpath.internal.axes.HasPositionalPredChecker;

class Solution {
    public int solution(String pos) {
        // Write code here.
        int answer = 0;
        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, -2, 2, 1, -1};
        int y = pos.charAt(0) - 'A';
        int x = pos.charAt(1) - '1';
        char[][] a = new char[8][8];
        a[x][y] = 'X';

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
                a[nx][ny] = 'O';
                answer++;
            }
        }

        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        return answer;
    }

    // The following is main method to output testcase.
    public static void main(String[] args) {
        Solution sol = new Solution();
        String pos = "A7";
        int ret = sol.solution(pos);

        // Press Run button to receive output. 
        System.out.println("Solution: return value of the method is " + ret + " .");
    }
}