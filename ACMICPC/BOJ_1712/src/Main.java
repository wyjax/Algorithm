import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();

        if (c - b <= 0)
            System.out.println(-1);
        else {
            System.out.println(a / (c - b) + 1);
        }
    }
}