import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
* 더 빠르고 메모리 적은 방법
*
* */

public class Main {
    static int n, m;
    static ArrayList<Integer> a;
    static int visited[] = new int[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Set<Integer> s = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(st.nextToken());
            s.add(t);
            visited[t]++;
        }
        a = new ArrayList<>(s);
        search(0, "");
    }

    public static void search(int cnt, String str) {
        if (cnt == m) {
            System.out.println(str);
            return;
        }

        for (int i = 0; i < a.size(); i++) {
            if (visited[a.get(i)] > 0) {
                visited[a.get(i)]--;
                search(cnt + 1, str + a.get(i) + " ");
                visited[a.get(i)]++;
            }
        }
    }
}