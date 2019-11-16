import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.Queue;
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
        pan = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pan[i][j] = sc.nextInt();
            }
        }

        solve(0);
        System.out.println(max);
    }

    public void solve(int cnt) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (max < pan[i][j]) {
                    max = pan[i][j];
                }
            }
        }

        if (cnt == 5) return;

        int[][] board = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = pan[i][j];

        for (int i = 0; i < 4; i++) {
            moving(i);
            solve(cnt + 1);

            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    pan[j][k] = board[j][k];
        }
    }

    public void moving(int direct) {
        Queue<Integer> q = new LinkedList<>();

        // 왼
        if (direct == 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (pan[i][j] == 0) continue;

                    for (int k = j + 1; k < n; k++) {
                        if (pan[i][k] == 0) continue;
                        if (pan[i][j] != pan[i][k]) break;
                        if (pan[i][j] == pan[i][k]) {
                            pan[i][j] *= 2;
                            pan[i][k] = 0;
                            j = k;
                            break;
                        }
                    }
                }
                for (int j = 0; j < n; j++) {
                    if (pan[i][j] == 0) continue;
                    q.add(pan[i][j]);
                    pan[i][j] = 0;
                }
                int size = q.size();
                for (int j = 0; j < size; j++)
                    pan[i][j] = q.poll();
            }
        }
        // 우
        else if (direct == 1) {
            for (int i = 0; i < n; i++) {
                for (int j = n - 1; j >= 0; j--) {
                    if (pan[j][i] == 0) continue;
                    for (int k = j - 1; k >= 0; k--) {
                        if (pan[k][i] == 0) continue;
                        if (pan[j][i] != pan[k][i]) break;
                        if (pan[j][i] == pan[k][i]) {
                            pan[j][i] *= 2;
                            pan[k][i] = 0;
                            j = k;
                            break;
                        }
                    }
                }
                for (int j = n - 1; j >= 0; j--) {
                    if (pan[j][i] == 0) continue;
                    q.add(pan[j][i]);
                    pan[j][i] = 0;
                }
                int size = q.size();
                for (int j = 0; j < size; j++) {
                    pan[n - 1 - j][i] = q.poll();
                }
            }
        }
        // 좌
        else if (direct == 2) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (pan[j][i] == 0) continue;
                    for (int k = j + 1; k < n; k++) {
                        if (pan[k][i] == 0) continue;
                        if (pan[j][i] != pan[k][i]) break;
                        if (pan[j][i] == pan[j][i]) {
                            pan[j][i] *= 2;
                            pan[k][i] = 0;
                            j = k;
                            break;
                        }
                    }
                }
                for (int j = 0; j < n; j++) {
                    if (pan[j][i] == 0) continue;
                    q.add(pan[j][i]);
                    pan[j][i] = 0;
                }
                int size = q.size();
                for (int j = 0; j < size; j++)
                    pan[j][i] = q.poll();
            }
        } else if (direct == 3) {
            for (int i = 0; i < n; i++) {
                for (int j = n - 1; j >= 0; j--) {
                    if (pan[i][j] == 0) continue;
                    for (int k = j - 1; k >= 0; k--) {
                        if (pan[i][k] == 0) continue;
                        if (pan[i][j] != pan[i][k]) break;
                        if (pan[i][j] == pan[i][k]) {
                            pan[i][j] *= 2;
                            pan[i][k] = 0;
                            j = k;
                            break;
                        }
                    }
                }
                for (int j = n - 1; j >= 0; j--) {
                    if (pan[i][j] == 0) continue;
                    q.add(pan[i][j]);
                    pan[i][j] = 0;
                }
                int size = q.size();
                for (int j = 0; j < size; j++)
                    pan[i][n - 1 - j] = q.poll();
            }
        }
    }
}