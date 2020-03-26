import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long answer = 0;
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String s = br.readLine();

        for (int i = 0; i + k <= n; i++) {
            long tmp = Long.parseLong(s.substring(i, i + k));
            answer = Math.max(answer, tmp);
        }
        System.out.println(answer);
    }
}
