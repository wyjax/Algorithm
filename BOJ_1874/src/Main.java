import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int m = 0;

        Stack<Integer> stack = new Stack<>();
        StringBuilder ans = new StringBuilder("");

        while (n-- > 0) {
            int x = sc.nextInt();

            // m이 x보다 작을 경우
            if (m < x) {
                // 스택에 m이 x가 될 때까지 넣는다.
                while (m < x) {
                    // m의 값을 계속 기억한다. ~부터 넣어야할 값
                    stack.push(++m);
                    ans.append("+\n");
                }
                stack.pop();
                ans.append("-\n");
            }
            else {
                if (stack.peek() != x) {
                    System.out.println("NO");
                    return;
                }
                stack.pop();
                ans.append("-\n");
            }
        }
        System.out.println(ans.toString());
    }
}
