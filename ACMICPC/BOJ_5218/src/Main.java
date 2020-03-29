import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            bw.write("Distances: ");

            for (int i = 0; i < a.length(); i++) {
                int sub = b.charAt(i) - a.charAt(i);
                if (sub < 0)
                    sub += 26;
                bw.write(sub + " ");
            }
            bw.write("\n");
            bw.flush();
        }
    }
}
