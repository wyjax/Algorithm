import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] d = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            // 방문하지 않은 정점은 -1로 초기화
            Arrays.fill(d[i], -1);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(0);
        //s  c
        d[1][0] = 0;

        while (q.size() > 0) {
            int s = q.remove();
            int c = q.remove();

            // 복사
            if (d[s][s] == -1) {
                d[s][s] = d[s][c] + 1;
                q.add(s);
                q.add(s);
            }
            // 북여넣기
            if (s + c <= n && d[s + c][c] == -1) {
                d[s + c][c] = d[s][c] + 1;
                q.add(s + c);
                q.add(c);
            }
            if (s - 1 >= 0 && d[s - 1][c] == -1) {
                d[s - 1][c] = d[s][c] + 1;
                q.add(s - 1);
                q.add(c);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            if (d[n][i] != -1) {
                if (ans > d[n][i])
                    ans = d[n][i];
            }
        }
        System.out.println(ans);
    }
}
