import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int m = sc.nextInt();
        int[] chon = new int[n + 1];
        Arrays.fill(chon, -1);

        ArrayList<Integer>[] list = new ArrayList[n + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();
            list[parent].add(child);
            list[child].add(parent);
        }

        Queue<Integer> q = new LinkedList<>();
        chon[a] = 0;
        q.add(a);

        while (q.size() > 0) {
            int cur = q.remove();
            if (cur == b)
                break;

            for (int i = 0; i < list[cur].size(); i++) {
                int next = list[cur].get(i);
                if (chon[next] != -1) continue;
                chon[next] = chon[cur] + 1;
                q.add(next);
            }
        }

        System.out.println(chon[b]);
    }
}
