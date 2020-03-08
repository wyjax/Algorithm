import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        while (a > 0 || b > 0) {
            a -= c;
            b -= d;
            l--;
        }
        System.out.println(l);
    }
}