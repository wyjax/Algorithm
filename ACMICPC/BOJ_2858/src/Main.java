import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int b = sc.nextInt();
        int sum = r + b;

        for (int i = 3; i < sum; i++) {
            if (sum % i > 0) continue;
            int j = sum / i;

            int tb = (i - 2) * (j - 2);
            if (tb == b) {
                System.out.println(Math.max(i, j) + " " + Math.min(i, j));
                break;
            }
        }
    }
}
