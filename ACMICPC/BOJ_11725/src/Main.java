import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer>[] list = new ArrayList[n];
        int[] a = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int parent = sc.nextInt() - 1;
            int son = sc.nextInt() - 1;
            list[parent].add(son);
            list[son].add(parent);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;

        while (q.size() > 0) {
            int x = q.remove();

            for (int i = 0; i < list[x].size(); i++) {
                if (visited[list[x].get(i)]) continue;
                visited[list[x].get(i)] = true;
                a[list[x].get(i)] = x;
                q.add(list[x].get(i));
            }
        }

        for (int i = 1; i < n; i++) {
            System.out.println(a[i] + 1);
        }
    }
}