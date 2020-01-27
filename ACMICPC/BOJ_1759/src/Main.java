import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n, m;
    static String[] a;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new String[m];
        check = new boolean[m];

        for (int i = 0; i < m; i++) {
            a[i] = sc.next();
        }

        Arrays.sort(a);
        search(0, 0,"");
    }

    public static void search(int cnt, int sel, String str) {
        if (cnt == n) {
            if (validation(str)) {
                System.out.println(str);
            }
            return;
        }

        for (int i = sel; i < m; i++) {
            check[i] = true;
            search(cnt + 1, i + 1, str + a[i]);
            check[i] = false;
        }
    }

    public static boolean validation(String s) {
        char[] tmp = s.toCharArray();
        int a = 0;
        int b = 0;

        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] == 'a' || tmp[i] == 'e' || tmp[i] == 'i' || tmp[i] == 'o' || tmp[i] == 'u') {
                a++;
            }
            else {
                b++;
            }
        }
        return (a >= 1 && b >= 2);
    }
}