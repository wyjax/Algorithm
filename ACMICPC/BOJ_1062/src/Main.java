import java.util.Scanner;

public class Main {
    static int n, k;
    static int[] alpha = new int[26];
    static String[] s;
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        s = new String[n];

        alpha['a'- 'a']++;
        alpha['n'- 'a']++;
        alpha['t'- 'a']++;
        alpha['i'- 'a']++;
        alpha['c'- 'a']++;

        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        search(k - 5, 0);
        System.out.println(ans);
    }

    static void search(int cnt, int idx) {
        if (cnt == 0) {
            count();
            return;
        }

        for (int i = idx; i < 26; i++) {
            if (alpha[i] > 0) continue;
            alpha[i] += 1;
            search(cnt - 1, i + 1);
            alpha[i] -= 1;
        }
    }

    static void count() {
        int tmp = 0;
        for (String s : s) {
            boolean res = true;

            for (char c : s.toCharArray()) {
                if (alpha[c - 'a'] == 0) {
                    res = false;
                    break;
                }
            }
            if (res)
                tmp++;
        }
        if (ans < tmp)
            ans = tmp;
    }
}