import java.util.Scanner;

public class Main {
    static int n;
    static int[][] a;
    static boolean[] visited;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            dfs(i, i, 1 ,0);
            visited[i] = false;
        }
        System.out.println(ans);
    }

    public static void dfs(int first, int pre, int cnt, int sum) {
        if (cnt == n) {
            if (a[pre][first] == 0) return;
            sum += a[pre][first];
            ans = Math.min(ans, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            if (a[pre][i] == 0) continue;
            if (sum + a[pre][i] > ans) continue;

            visited[i] = true;
            dfs(first, i, cnt + 1, sum + a[pre][i]);
            visited[i] = false;
        }
    }
}

/*

// 이전 풀이

import java.util.Scanner;

public class Main {
    static int n;
    static int[][] a;
    static boolean[] visited;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            dfs(i, i, 0, 0);
        }
        System.out.println(ans);
    }

    public static void dfs(int first, int pre, int cnt, int sum) {
        if (cnt == n && first == pre) {
            sum += a[pre][first];
            ans = Math.min(ans, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            if (a[pre][i] == 0) continue;
            if (sum + a[pre][i] > ans) continue;

            visited[i] = true;
            dfs(first, i, cnt + 1, sum + a[pre][i]);
            visited[i] = false;
        }
    }
}

 */