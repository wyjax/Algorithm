import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] a = new String[n];
            Trie root = new Trie();
            Trie node = root;

            for (int i = 0; i < n; i++)
                a[i] = br.readLine();
            Arrays.sort(a);
            boolean check = false;

            for (int i = 0; i < n; i++) {
                node = root;

                for (int j = 0; j < a[i].length(); j++) {
                    int idx = a[i].charAt(j) - '0';

                    if (node.child == null) {
                        node.child = new Trie[10];
                        node.finish = false;
                    }
                    if (node.finish && node.child[idx] != null) {
                        check = true;
                        break;
                    }
                    if (node.child[idx] == null)
                        node.child[idx] = new Trie();
                    if (j == a[i].length() - 1)
                        node.finish = true;
                    else
                        node = node.child[idx];
                }
                if (check)
                    break;
            }
            if (check)
                bw.write("NO\n");
            else
                bw.write("YES\n");
            bw.flush();
        }
    }
}

class Trie {
    Trie[] child;
    boolean finish;
}