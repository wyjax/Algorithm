import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int n = board.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < moves.length; i++) {
            int cur = moves[i] - 1;

            for (int j = 0; j < n; j++) {
                if (board[j][cur] == 0) continue;
                int val = board[j][cur];
                if (stack.size() > 0 && val == stack.peek()) {
                    answer += 2;
                    stack.pop();
                }
                else {
                    stack.add(val);
                }
                board[j][cur] = 0;
                break;
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
