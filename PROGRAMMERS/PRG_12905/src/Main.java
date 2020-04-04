
class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;

        if (n < 2 || m < 2) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 1)
                        return 1;
                }
            }
            return 0;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (board[i + 1][j + 1] == 0) continue;

                board[i + 1][j + 1] += Math.min(board[i][j], Math.min(board[i + 1][j], board[i][j + 1]));
                answer = Math.max(answer, board[i + 1][j + 1]);
            }
        }
        return answer * answer;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}