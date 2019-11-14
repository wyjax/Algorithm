import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int N;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int [][]house = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");

            for(int j = 0; j < s.length; j++)
                house[i][j] = Integer.parseInt(s[j]);
        }

        new Solution().solution(N, house);
    }
}

class Solution {
    int n;
    int answer = 0;
    int []dx = {0, 1, 1};
    int []dy = {1, 0, 1};
    boolean [][]check;
    int [][]maps;

    public void solution(int N, int [][]arr) {
        n = N;
        check = new boolean[n][n];
        maps = arr;

        solve(0, 1, 0);
        System.out.println(answer);
    }
    // 1: 가로 2:세로 3:대각선

    public void solve(int x, int y, int type) {
        if (x == n - 1 && y == n - 1) {
            answer++;
            return;
        }
        // 0 가로 1 세로 2 대각선

        for(int i = 0; i < dx.length; i++) {
            if (type == 0 && i == 1) continue;
            if (type == 1 && i == 0) continue;

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || maps[nx][ny] == 1)
                continue;
            if (i == 2 && (maps[nx - 1][ny] == 1 || maps[nx][ny - 1] == 1))
                continue;

            solve(nx, ny, i);
        }
    }
}