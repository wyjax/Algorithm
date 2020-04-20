import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        ListNode tmp = head;

        while (tmp != null) {
            count++;
            tmp = tmp.next;
        }

        for (int i = 0; i < count / 2; i++) {
            stack.push(head.val);
            head = head.next;
        }
        if (count % 2 == 1) {
            head = head.next;
            count--;
        }
        for (int i = count / 2; i < count; i++) {
            if (head.val != stack.pop())
                return false;
            head = head.next;
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
