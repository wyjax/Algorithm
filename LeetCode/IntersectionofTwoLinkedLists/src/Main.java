import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> nodeContainer = new HashSet<>();

        while (headA != null) {
            nodeContainer.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (nodeContainer.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
