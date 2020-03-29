import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        while (n-- > 0) {
            Stack<Character> stack = new Stack<>();
            char[] s = br.readLine().toCharArray();

            for (int i = 0; i < s.length; i++) {
                if (stack.size() > 0) {
                    char cc = stack.peek();
                    if (s[i] == cc)
                        stack.pop();
                    else
                        stack.add(s[i]);
                }
                else
                    stack.add(s[i]);
            }
            if (stack.size() == 0)
                answer++;
        }
        System.out.println(answer);
    }
}