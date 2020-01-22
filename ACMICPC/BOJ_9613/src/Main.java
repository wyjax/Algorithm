import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int []arr = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            long a = 0;

            for (int i = 0; i < n - 1; i++) {
                for(int j = i + 1; j < n; j++) {
                    a += gcd(arr[i], arr[j]);
                }
            }
            System.out.println(a);
        }
    }

    public static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x%y);
        }
    }
}