import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] a = new int[200001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        int tcno = 1;

        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int len = 0, cluster = 0;
            int zeroCnt = 0;
            int cur = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                boolean check = true;

                if (a[i] == 1) {

                    zeroCnt = 0;
                    cluster++;
                    int cnt = 5;

                    for (int j = i - 1; j >= 0 && cnt > 0; j--) {
                        if (a[j] == 0) {
                            len += i - j;
                            cnt--;
                        }
                        else if (a[j] == 1 && check) {
                            cluster--;
                            check = false;
                        }
                    }
                }
                else {
                    cur++;
                    zeroCnt++;
                    if (zeroCnt > 5)
                        cluster++;
                }
            }
            cluster += zeroCnt;
            sb.append("#");
            sb.append(tcno);
            sb.append(" ");
            sb.append(len);
            sb.append(" ");
            sb.append(cluster);
            sb.append("\n");
            tcno = tcno + 1;
        }
        System.out.println(sb.toString());
    }
}