import java.util.Scanner;

public class Main {
    /*
       문제 : 2 x n 타일
       DFS로도 풀 수 있지만 시간초과때문에 반복성을 찾아서 DP로 해결
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 10007;
        }
        System.out.println(dp[n]);
    }
}