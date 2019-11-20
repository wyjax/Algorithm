import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String s = sc.nextLine();

        boolean check = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '<') {
                while (stack.size() > 0)
                    sb.append(stack.pop());

                check = true;
                sb.append(c);
            }
            else if (c == '>') {
                check = false;
                sb.append(c);
            }
            else if (check) {
                sb.append(c);
            }
            else {
                if (c == ' ') {
                    while (stack.size() > 0)
                        sb.append(stack.pop());
                    sb.append(c);
                }
                else {
                    stack.push(c);
                }
            }
        }
        while (stack.size() > 0)
            sb.append(stack.pop());

        System.out.println(sb.toString());
    }
}