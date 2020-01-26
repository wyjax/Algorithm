import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[] a;
    static boolean[] check;
    static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        set = new TreeSet<>();
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        a = new int[n];
        check = new boolean[n];

        s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(s[i]);
        }

        search(0, "");
        List<String> list = new ArrayList<>(set);
        set.clear();
        a = null;
        check = null;

        Collections.sort(list, (o1, o2) -> {
            String[] s1 = o1.split(" ");
            String[] s2 = o2.split(" ");

            for (int i = 0; i < s1.length; i++) {
                int a = Integer.parseInt(s1[i]);
                int b = Integer.parseInt(s2[i]);

                if (a < b)
                    return -1;
                else if (a > b)
                    return 1;
            }
            return 0;
        });

        StringBuilder sb = new StringBuilder("");
        for (String str : list)
            sb.append(str + "\n");
        System.out.print(sb.toString());
    }

    public static void search(int cnt, String str) {
        if (cnt == m) {
            set.add(str);
            return;
        }

        for (int i = 0; i < a.length; i++) {
            if (!check[i]) {
                check[i] = true;
                search(cnt + 1, str + a[i] + " ");
                check[i] = false;
            }
        }
    }
}