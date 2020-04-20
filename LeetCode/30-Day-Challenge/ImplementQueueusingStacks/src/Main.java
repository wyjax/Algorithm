import java.util.Stack;

class MyQueue {
    private Stack<Integer> leftStack = new Stack<>();
    private Stack<Integer> rightStack = new Stack<>();
    int top = -1;

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        leftStack.add(x);
        top = x;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (rightStack.isEmpty()) {
            while (!leftStack.isEmpty()) {
                rightStack.push(leftStack.pop());
            }
        }

        return rightStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (rightStack.isEmpty()) {
            while (!leftStack.isEmpty()) {
                rightStack.push(leftStack.pop());
            }
        }
        return rightStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (leftStack.isEmpty() && rightStack.isEmpty());
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
