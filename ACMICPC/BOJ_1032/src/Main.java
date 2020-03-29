import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n];

        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }

        int m = s[0].length();
        char[] c = new char[m];

        for (int i = 0; i < m; i++) {
            boolean check = false;
            char obj = s[0].charAt(i);

            for (int j = 1; j < n; j++) {
                if (obj != s[j].charAt(i)) {
                    check = true;
                    c[i] = '?';
                    break;
                }
            }
            if (!check)
                c[i] = obj;
        }

        for (int i = 0; i < m; i++)
            System.out.print(c[i]);
    }
}
