import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Pair[] jew = new Pair[n];
        int[] bag = new int[k];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            jew[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < k; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bag);
        Arrays.sort(jew);
        Queue<Integer> q = new PriorityQueue<>();
        long ans = 0;
        int idx = 0;

        for (int i = 0; i < k; i++) {
            while (idx < n && jew[idx].p <= bag[i]) {
                q.add(-jew[idx].w);
                idx++;
            }
            if (q.size() > 0)
                ans += Math.abs(q.remove());
        }

        System.out.println(ans);
    }
}

class Pair implements Comparable<Pair> {
    int w;
    int p;

    public Pair(int p, int w) {
        this.p = p;
        this.w = w;
    }

    @Override
    public int compareTo(Pair o) {
        return this.p - o.p;
    }
}