import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(search(a, 6, 5) + search(b, 6, 5));
        System.out.println(search(a, 5, 6) + search(b, 5, 6));
    }

    public static int search(int x, int from, int to) {
        int ret = 0;
        int div = 1;
        while (x > 0) {
            int tmp = x % 10;
            if (tmp == from)
                tmp = to;
            ret += tmp * div;
            x /= 10;
            div *= 10;
        }
        return ret;
    }
}
