
class Solution {
    public String stringShift(String s, int[][] shift) {
        int sum = 0;

        for (int i = 0; i < shift.length; i++) {
            int val = (shift[i][0] == 0) ? -1 : 1;
            sum += (val * shift[i][1]);
        }
        sum %= s.length();
        if (sum > 0) {
            return s.substring(s.length() - sum, s.length()) + s.substring(0, s.length() - sum);
        }
        else if (sum < 0) {
            sum = -sum;
            return s.substring(sum, s.length()) + s.substring(0, sum);
        }
        return s;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] a = {{1, 1}, {1, 1}, {0, 2}, {1, 3}};
        int[][] b = {{0, 1}, {1, 2}};
        int[][] c = {{1, 1}};
        int[][] d = {{1, 8}, {1, 4}, {1, 3}, {1, 6}, {0, 6}, {1, 4}, {0, 2}, {0, 1}};
        System.out.println(new Solution().stringShift("yisxjwry", d));
    }
}

/*
"mecsk"
[[1,4],[0,5],[0,4],[1,1],[1,5]]

"yisxjwry"
[[1,8],[1,4],[1,3],[1,6],[0,6],[1,4],[0,2],[0,1]]
 */