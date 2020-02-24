import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] a = new int[n];

        int idx = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            int val = lowers(a, idx, num);
            a[val] = num;
            if (idx == val)
                idx++;
        }

        System.out.println(idx);
    }

    static int lowers(int[] a, int n, int key) {
        int left = 0;
        int right = n;

        while (left < right) {
            int mid = (left + right) / 2;
            if (key <= a[mid])
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
}
