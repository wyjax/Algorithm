import java.util.Stack;

public class Main {
    public static void main(String[] args) {

    }
}

class MinStack {
    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        min = Math.min(min, x);
    }

    public void pop() {
        if (!stack.isEmpty()) {
            int x = stack.pop();
            min = Integer.MAX_VALUE;

            for (Integer num : stack) {
                min = Math.min(min, num);
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}