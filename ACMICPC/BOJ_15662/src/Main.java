import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char [][]t = new char[n][8];

        for (int i = 0; i < n; i++) {
            t[i] = sc.next().toCharArray();
        }

        int l = sc.nextInt();

        while (l-- > 0) {
            int no = sc.nextInt() - 1;
            int dir = sc.nextInt();

            int []d = new int[n];
            d[no] = dir;

            for (int i = no; i > 0; i--) {
                if (t[i - 1][2] != t[i][6])
                    d[i - 1] = -d[i];
                else
                    break;
            }

            for (int i = no; i < n - 1; i++) {
                if (t[i][2] != t[i + 1][6])
                    d[i + 1] = -d[i];
                else
                    break;
            }

            for (int i = 0; i < n; i++) {
                if (d[i] == 0) continue;
                if (d[i] == 1) {
                    char temp = t[i][7];
                    for (int j = 7; j >= 1; j--) {
                        t[i][j] = t[i][j - 1];
                    }
                    t[i][0] = temp;
                }
                else if (d[i] == -1) {
                    char temp = t[i][0];
                    for (int j = 0; j < 7; j++) {
                        t[i][j] = t[i][j + 1];
                    }
                    t[i][7] = temp;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (t[i][0] == '1') {
                ans ++;
            }
        }
        System.out.println(ans);
    }
}