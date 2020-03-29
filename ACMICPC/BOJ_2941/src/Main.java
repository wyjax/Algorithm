import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        String s = br.readLine();
        Set<String> set = new HashSet<>();
        set.add("c=");
        set.add("c-");
        set.add("dz=");
        set.add("d-");
        set.add("lj");
        set.add("nj");
        set.add("s=");
        set.add("z=");

        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j < 4 && i + j <= s.length(); j++) {
                String tmp = s.substring(i, i + j);
                if (set.contains(tmp)) {
                    i = i + j - 1;
                    break;
                }
            }
            answer++;
        }
        System.out.println(answer);
    }
}
