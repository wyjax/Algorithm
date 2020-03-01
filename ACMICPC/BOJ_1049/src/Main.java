import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int six = Integer.MAX_VALUE;
        int one = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            six = Math.min(a, six);
            one = Math.min(b, one);
        }
        if (one * 6 <= six) {
            System.out.println(n * one);
        }
        else {
            int sum = (n / 6) * six;
            n %= 6;

            if (n * one > six)
                sum += six;
            else
                sum += n * one;
            System.out.println(sum);
        }
    }
}