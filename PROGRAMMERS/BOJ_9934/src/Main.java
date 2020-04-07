import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Node root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int maxn = (int) (Math.pow(2, k) - 1);

        int[] a = new int[maxn + 1];
        for (int i = 1; i <= maxn; i++)
            a[i] = Integer.parseInt(st.nextToken());

        root = new Node();

    }

    static void binary(int start, int end) {
        if (end == start) return;


    }
}

class Node {
    int val;
    Node[] next = new Node[2];
}

// 6 12 24
// 7 19