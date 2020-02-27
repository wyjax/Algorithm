import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int team = Math.min(n / 2, m);
        int cnt = (n - (team * 2)) + (m - team);

        int ans = 0;
        while (ans < k) {
            if (cnt > 0) {
                cnt--;
                ans++;
            }
            else if (cnt == 0) {
                team--;
                ans++;
                cnt = 2;
            }
        }
        team = team < 0 ? 0 : team;
        System.out.println(team);
    }
}