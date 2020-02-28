import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (n-- > 0) {
            int r = sc.nextInt();
            int e = sc.nextInt();
            int c = sc.nextInt();
            int ans = e - c;

            if (ans == r)
                System.out.println("does not matter");
            else if (ans > r)
                System.out.println("advertise");
            else
                System.out.println("do not advertise");
        }
    }
}