class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null)
            return null;

        ListNode root = new ListNode(head.val);
        ListNode ans = root;
        head = head.next;

        while (head != null) {
            if (head.val != val) {
                root.next = new ListNode(head.val);
                root = root.next;
            }

            head = head.next;
        }

        return ans;
    }

    public ListNode removeElements2(ListNode head, int val) {
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode node = root;

        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            }
            else {
                node = node.next;
            }
        }

        return root.next;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
