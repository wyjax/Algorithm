class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = null;

        if (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node = l1;
                l1 = l1.next;
            }
            else {
                node = l2;
                l2 = l2.next;
            }
        }
        else if (l1 != null) {
            node = l1;
            l1 = l1.next;
        }
        else if (l2 != null) {
            node = l2;
            l2 = l2.next;
        }
        ListNode root = node;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                node = node.next;
                l1 = l1.next;
            }
            else {
                node.next = l2;
                node = node.next;
                l2 = l2.next;
            }
        }

        while (l1 != null) {
            node.next = l1;
            node = node.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            node.next = l2;
            node = node.next;
            l2 = l2.next;
        }
        return root;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Main {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(4);
        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;
        b1.next = b2;
        b2.next = b3;

        new Solution().mergeTwoLists(a1, b1);
    }
}
