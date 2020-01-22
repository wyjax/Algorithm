import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long m = sc.nextInt();
        long two = 0, five = 0;

        for (long i = 2; i <= n; i *= 2) {
            two += n / i;
        }
        for (long i = 2; i <= n - m; i *= 2) {
            two -= (n - m) / i;
        }
        for (long i = 2; i <= m; i *= 2) {
            two -= m / i;
        }
        for (long i = 5; i <= n; i *= 5) {
            five += n / i;
        }
        for (long i = 5; i <= n - m; i *= 5) {
            five -= (n - m) / i;
        }
        /*
        • 팩토리얼은 2의 개수가 5의 개수 보다 항상 많기 때문에, 5의 개수만 세어줬는데
        • 조합은 어떻게 될 지 모르기 때문에, 2의 개수와 5의 개수를 동시에 세어줘야 한다
         */
        for (long i = 5; i <= m; i *= 5) {
            five -= m / i;
        }
        System.out.println(Math.min(two, five));
    }
}