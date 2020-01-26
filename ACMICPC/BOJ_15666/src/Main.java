import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[] a;
    static Set<String> set = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        search(0, 0,"");
        List<String> list = new ArrayList<>(set);
        Collections.sort(list, (o1, o2) -> {
            StringTokenizer s1 = new StringTokenizer(o1);
            StringTokenizer s2 = new StringTokenizer(o2);

            for (int i = 0; i < m; i++) {
                int a = Integer.parseInt(s1.nextToken());
                int b = Integer.parseInt(s2.nextToken());

                if (a > b)
                    return 1;
                else if (a < b)
                    return -1;
            }
            return 0;
        });

        for (String s : list)
            System.out.println(s);
    }

    public static void search(int cnt, int sel, String s) {
        if (cnt == m) {
            set.add(s);
            return;
        }

        for (int i = sel; i < n; i++) {
            search(cnt + 1, i, s + a[i] + " ");
        }
    }
}