import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] a = new int[n][4];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
            a[i][2] = Integer.parseInt(st.nextToken());
            a[i][3] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int tmp = o2[1] - o1[1];
                if (tmp != 0)
                    return tmp;
                tmp = o2[2] - o1[2];
                if (tmp != 0)
                    return tmp;
                return o2[3] - o1[3];
            }
        });
        int count = 0;
        int rank = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0 && (a[i][1] != a[i - 1][1] || a[i][2] != a[i - 1][2] || a[i][3] != a[i - 1][3])) {
                rank += count;
                count = 0;
            }
            if (a[i][0] == k)
                break;
            count++;
        }
        System.out.println(rank);
    }
}

/*
5 4
1 1 2 3
5 1 2 2
4 1 2 1
2 1 3 0
3 2 2 0
 */