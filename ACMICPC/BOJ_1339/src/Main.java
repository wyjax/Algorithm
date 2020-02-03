import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    static int maxs = 0;
    static int n, m = 0;
    static boolean[] check;
    static String[] a;
    static Character[] letters;
    static int[] alpha = new int[26];
    static int[] d2;
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new String[n];
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            a[i] = br.readLine();
            for (char c : a[i].toCharArray())
                set.add(c);
        }
        letters = set.toArray(new Character[set.size()]);
        check = new boolean[letters.length];
        m = letters.length;

        d = new int[m];
        d2 = new int[m];
        for (int i = 0; i < m; i++) {
            d[i] = 9 - i;
        }
        dfs(0, m);
        System.out.println(maxs);
    }

    static void dfs(int cnt, int m) {
        if (cnt == m) {
            int tmp = calculate();
            if (maxs < tmp)
                maxs = tmp;
        }

        for (int i = 0; i < m; i++) {
            if (check[i]) continue;
            check[i] = true;
            d2[cnt] = d[i];
            dfs(cnt +  1, m);
            check[i] = false;
        }
    }

    static int calculate() {
        int sum = 0;

        for (int i = 0; i < m; i++) {
            alpha[letters[i] - 'A'] = d2[i];
        }
        for (String s : a) {
            int now = 0;
            for (char x : s.toCharArray())
                now = now * 10 + alpha[x - 'A'];
            sum += now;
        }
        return sum;
    }
}