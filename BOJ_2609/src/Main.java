import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int ans1 = gcd(a, b);
        System.out.println(ans1);
        System.out.println((a * b / ans1));
    }

    public static int gcd(int a, int b) {
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        while (b > 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }
}