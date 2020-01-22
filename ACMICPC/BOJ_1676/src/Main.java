import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;

        for (int i = 5; i <= n; i += 5) {
            if (i % 5 == 0) {
                int tmp = i;
                while (tmp % 5 == 0) {
                    tmp /= 5;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}

// 더 좋은 코드
/*
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        for (int i=5; i<=n; i*=5) {
            ans += n/i;
        }
        System.out.println(ans);
    }
}
 */