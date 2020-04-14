

class Solution {
    int hourglassSum(int[][] arr) {
        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr[i].length - 2; j++) {
                int sum = 0;

                for (int r = i; r < i + 3; r++) {
                    for (int c = j; c < j + 3; c++) {
                        sum += arr[r][c];
                    }
                }
                sum -= (arr[i + 1][j] + arr[i + 1][j + 2]);
                answer = Math.max(answer, sum);
            }
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
