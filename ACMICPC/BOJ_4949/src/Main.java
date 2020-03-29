import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String tc = br.readLine();
            if (tc.equals("."))
                break;

            System.out.println(matchs(tc));
        }
    }

    public static String matchs(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            }
            else if (c == '[') {
                stack.push(c);
            }
            else if (c == ')' || c == ']') {
                char co = (c == ')' ? '(' : '[');

                if (stack.size() == 0 ||
                        stack.pop() != co) {
                    return "no";
                }
            }
        }
        if (stack.size() > 0) return "no";
        return "yes";
    }
}
