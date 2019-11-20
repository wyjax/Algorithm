import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> s = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int []a = new int[n];
        int []ans = new int[n];

        String []tmp = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(tmp[i]);
        }

        for (int i = 0; i < n; i++) {
            while (s.size() > 0 && a[s.peek()] < a[i]) {
                ans[s.pop()] = a[i];
            }
            s.push(i);
        }

        while (s.size() > 0)
            ans[s.pop()] = -1;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int num : ans)
            bw.write(num + " ");
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}