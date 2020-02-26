import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();
        double pi = 3.14159265359;

        System.out.printf("%f\n", (n * n) * pi);
        System.out.println(2 * (n * n));
    }
}