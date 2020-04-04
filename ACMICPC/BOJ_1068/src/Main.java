import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer>[] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int root = -1;

        list = new ArrayList[n];
        for (int i = 0; i < n; i++)
            list[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int idx = sc.nextInt();
            if (idx == -1) {
                root = i;
                continue;
            }
            list[idx].add(i);
        }
        int k = sc.nextInt();
        System.out.println(bfs(root, k));
    }

    static int bfs(int root, int remove) {
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        int sum = 0;

        if (root == remove)
            return 0;

        while (q.size() > 0) {
            int x = q.remove();
            boolean check = true;

            for (int i = 0; i < list[x].size(); i++) {
                int next = list[x].get(i);
                if (next == remove) continue;
                q.add(next);
                check = false;
            }
            if (check)
                sum++;
        }

        if (sum == 0 && root != remove)
            return 1;

        return sum;
    }
}