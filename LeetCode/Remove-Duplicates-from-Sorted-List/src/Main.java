
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;

        ListNode ans = new ListNode(head.val);
        ListNode node = ans;

        int x = head.val;
        while (head.next != null) {
            head = head.next;
            if (head.val == x) continue;

            x = head.val;
            node.next = new ListNode(x);
            node = node.next;
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}