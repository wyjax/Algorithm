import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        for (int i = 0; i < m; i++) {
            if (search(b[i], 0, n - 1))
                bw.write("1 ");
            else
                bw.write("0 ");
        }
        bw.flush();
    }

    static boolean search(int val, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;

            if (a[mid] == val)
                return true;
            else if (a[mid] < val)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }
}
