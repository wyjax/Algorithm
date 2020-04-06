import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int p = sc.nextInt();

        int a_ans = a * p;
        int b_ans = b + ((p - c) > 0 ? (p - c) * d : 0);

        System.out.println(Math.min(a_ans, b_ans));
    }
}
