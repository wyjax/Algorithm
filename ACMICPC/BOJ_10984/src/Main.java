import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int c = 0;
            double g = 0.0;

            for (int i = 0; i < n; i++) {
                int first = sc.nextInt();
                double second = sc.nextDouble();
                c += first;
                g += (second * first);
            }
            System.out.println(c + " " + Math.round(g * 10 / c) / 10.0);
        }
    }
}
