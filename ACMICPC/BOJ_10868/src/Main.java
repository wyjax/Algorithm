import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int h = 1;
        while (h < n) {
            h <<= 1;
        }
        tree = new int[h * 2];
        initTree(1, 0, arr.length - 1);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken()) - 1;
            int right = Integer.parseInt(st.nextToken()) - 1;
            bw.write(searchMin(1, 0, arr.length - 1, left, right) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int searchMin(int node, int start, int end, int left, int right) {
        if (start > right || end < left) {
            return Integer.MAX_VALUE;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        int leftMin = searchMin(node * 2, start, mid, left, right);
        int rightMin = searchMin(node * 2 + 1, mid + 1, end, left, right);

        return Math.min(leftMin, rightMin);
    }

    static int initTree(int node, int left, int right) {
        if (left == right) {
            tree[node] = arr[left];
            return tree[node];
        }

        int mid = (left + right) / 2;
        int minLeft = initTree(node * 2, left, mid);
        int minRight = initTree(node * 2 + 1, mid + 1, right);
        tree[node] = Math.min(minLeft, minRight);

        return tree[node];
    }
}
