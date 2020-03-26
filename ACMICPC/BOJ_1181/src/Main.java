import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] s = new String[n];

        for (int i = 0; i < n; i++) {
            s[i] = br.readLine();
        }

        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length())
                    return 1;
                else if (o1.length() < o2.length())
                    return -1;

                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < n; i++) {
            if (i == 0 || !s[i].equals(s[i - 1]))
                bw.write(s[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
