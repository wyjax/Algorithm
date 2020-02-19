import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int now = a;

        int cycle = 0;

        while (true) {
            int first = now % 10;
            int second = (now / 10);
            int tmp = ((first + second) % 10) + (now % 10) * 10;
            cycle++;

            if (tmp == a) {
                break;
            }
            now = tmp;
        }

        System.out.println(cycle);
    }
}