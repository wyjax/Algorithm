import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] a;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        a = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            a[i] = Long.parseLong(st.nextToken());

        long left = 0;
        long right = 1000000000;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long ret = search(mid);

            if (ret >= m) {
                if (result < mid)
                    result = mid;
                left = mid + 1;
            }
            else if (ret < m)
                right = mid - 1;
        }
        System.out.println(result);
    }

    static Long search(long h) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > h)
                sum += a[i] - h;
        }
        return sum;
    }
}