import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int v;
    static int e;
    static int[] a;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            a = new int[v + 1];

            list = new ArrayList[v + 1];
            for (int i = 0; i < list.length; i++)
                list[i] = new ArrayList<>();
            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                list[first].add(second);
                list[second].add(first);
            }

            for (int i = 1; i < v + 1; i++) {
                if (a[i] == 0)
                    BFS(i);
            }

            boolean check = true;
            for (int i = 1; i <= v; i++) {
                for (int j = 0; j < list[i].size(); j++) {
                    if (a[i] == a[list[i].get(j)]) {
                        check = false;
                        break;
                    }
                }
                if (!check)
                    break;
            }
            if (check)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    static void BFS(int y) {
        Queue<Integer> q = new LinkedList<>();
        q.add(y);
        a[y] = 1;

        while (q.size() > 0) {
            int x = q.remove();

            for (int i = 0; i < list[x].size(); i++) {
                if (a[list[x].get(i)] == 0) {
                    a[list[x].get(i)] = 3 - a[x];
                    q.add(list[x].get(i));
                }
            }
        }
    }
}