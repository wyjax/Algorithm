import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[n + 1];
        ArrayList<Integer>[] list = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++)
            list[i] = new ArrayList<>();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            list[first].add(second);
            list[second].add(first);
        }

        Queue<Integer> q = new LinkedList<>();
        visited[1] = true;
        for (int i = 0; i < list[1].size(); i++) {
            int next= list[1].get(i);
            visited[next] = true;
            q.add(list[1].get(i));
        }
        int answer = q.size();

        while (q.size() > 0) {
            int x = q.remove();

            for (int i = 0; i < list[x].size(); i++) {
                int next = list[x].get(i);
                if (visited[next]) continue;
                visited[next] = true;
                answer++;
            }
        }

        System.out.println(answer);
    }
}
