import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    static int[][] map = new int[9][9];
    static ArrayList<Node> list = new ArrayList<>();
    static int size;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0)
                    list.add(new Node(i, j));
            }
        }
        size = list.size();
        solve(0, 0);
        System.out.println(sb.toString());
    }

    static void solve(int idx, int cnt) {
        if (cnt == size) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j] + " ");
                }
                sb.append("\n");
            }
            return;
        }

        Node node = list.get(idx);

        for (int j = 1; j < 10; j++) {
            if (!possible(node.x, node.y, j))
                continue;

            map[node.x][node.y] = j;
            solve(idx + 1, cnt + 1);
            map[node.x][node.y] = 0;
        }
    }

    static boolean possible(int x, int y, int v) {
        for (int i = 0; i < 9; i++) {
            if (map[i][y] == v || map[x][i] == v) {
                return false;
            }
        }
        for (int i = (x / 3) * 3; i < (x / 3) * 3 + 3; i++) {
            for (int j = (y / 3) * 3; j < (y / 3) * 3 + 3; j++) {
                if (map[i][j] == v) {
                    return false;
                }
            }
        }
        return true;
    }
}

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}