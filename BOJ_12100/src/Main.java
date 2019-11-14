import java.io.BufferedReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Solution().solution();
    }
}

class Solution {
    int[][] pan;
    int max = 0;
    int n;

    public void solution() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        pan = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pan[i][j] = sc.nextInt();
            }
        }

        solve(0);
        System.out.println(max);
    }

    public void solve(int cnt) {
        if (cnt == 5) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (max < pan[i][j])
                        max = pan[i][j];
                }
            }
            return;
        }

        int [][]board = pan;

        for (int i = 1; i < 5; i++) {
            moving(i);
            solve(cnt + 1);
            pan = board;
        }
    }

    public void moving(int direct) {
        if (direct == 1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (pan[i][j] == pan[i][j + 1]) {
                        pan[i][j] += pan[i][j + 1];
                        pan[i][j + 1] = 0;
                        j++;
                    }
                }

                for (int j = 0; j < n - 1; j++) {
                    if (pan[i][j] == 0) {
                        pan[i][j] = pan[i][j + 1];
                        pan[i][j + 1] = 0;
                    }
                }
            }
        }
        else if (direct == 2) {
            for (int i = 0; i < n; i++) {
                for (int j = n - 1; j > 0; j--) {
                    if (pan[i][j] == pan[i][j - 1]) {
                        pan[i][j] += pan[i][j - 1];
                        pan[i][j - 1] = 0;
                        j--;
                    }
                }

                for (int j = n - 1; j > 0; j--) {
                    if (pan[i][j] == 0) {
                        pan[i][j] = pan[i][j - 1];
                        pan[i][j - 1] = 0;
                    }
                }
            }
        }
        else if (direct == 3) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (pan[j][i] == pan[j + 1][i]) {
                        pan[j][i] += pan[j + 1][i];
                        pan[j + 1][i] = 0;
                        j++;
                    }
                }

                for (int j = 0; j < n - 1; j++) {
                    if (pan[i][j] == 0) {
                        pan[i][j] = pan[i][j + 1];
                        pan[i][j + 1] = 0;
                    }
                }
            }
        }
        else if (direct == 4) {
            for (int i = 0; i < n; i++) {
                for (int j = n - 1; j > 0; j--) {
                    if (pan[j][i] == pan[j - 1][i]) {
                        pan[j][i] += pan[j - 1][i];
                        pan[j - 1][i] = 0;
                        j--;
                    }
                }

                for (int j = n - 1; j > 0; j--) {
                    if (pan[i][j] == 0) {
                        pan[i][j] = pan[i][j - 1];
                        pan[i][j - 1] = 0;
                    }
                }
            }
        }
    }
}