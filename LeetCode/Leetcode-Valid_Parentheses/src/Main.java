import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{')
                stack.add(c);
            else {
                if (stack.isEmpty())
                    return false;
                if (c == ')' && stack.peek() != '(')
                    return false;
                else if (c == ']' && stack.peek() != '[')
                    return false;
                else if (c == '}' && stack.peek() != '{')
                    return false;
                stack.pop();
            }
        }

        if (!stack.isEmpty())
            return false;
        return true;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
