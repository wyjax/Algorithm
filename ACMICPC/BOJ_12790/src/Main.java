import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int hp = Integer.parseInt(st.nextToken());
            int mp = Integer.parseInt(st.nextToken());
            int at = Integer.parseInt(st.nextToken());
            int df = Integer.parseInt(st.nextToken());

            int item1 = Integer.parseInt(st.nextToken());
            int item2 = Integer.parseInt(st.nextToken());
            int item3 = Integer.parseInt(st.nextToken());
            int item4 = Integer.parseInt(st.nextToken());
            hp = (hp + item1) <= 1 ? 1 : (hp + item1);
            mp = (mp + item2) <= 1 ? 1 : (mp + item2);
            at = (at + item3) <= 0 ? 0 : (at + item3);
            df = (df + item4);

            bw.write(hp + (5 * mp) + (2 * at) + (2 * df) + "\n");
        }
        bw.flush();
    }
}
