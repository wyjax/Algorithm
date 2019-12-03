import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        int s = sc.nextInt();
        int m = sc.nextInt();

        int e1 = 1, s1 = 1, m1 = 1;

        int year = 1;
        while (true) {
            if (e1 == e && s1 == s && m1 == m) {
                System.out.println(year);
                break;
            }

            e1++;
            s1++;
            m1++;
            year++;

            if (e1 > 15) e1 = 1;
            if (s1 > 28) s1 = 1;
            if (m1 > 19) m1 = 1;
        }
    }
}
