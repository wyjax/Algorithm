import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> leftQueue = new LinkedList<>();
    private int top = -1;

    public MyStack() {

    }

    public void push(int x) {
        leftQueue.add(x);
        top = x;
    }

    public int pop() {
        Queue<Integer> rightQueue = new LinkedList<>();

        while (leftQueue.size() > 1) {
            int x = leftQueue.remove();
            rightQueue.add(x);
        }
        while (!rightQueue.isEmpty()) {
            int x = top = rightQueue.remove();
            leftQueue.add(x);
        }

        return leftQueue.remove();
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return leftQueue.isEmpty();
    }
}

public class Main {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(4);
        stack.push(5);
        stack.push(2);
        stack.push(2); // 2 2 5 4 1
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.pop());
    }
}
