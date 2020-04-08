public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode node = head;

        while (node.next != null) {
            node = node.next;
            count++;
        }
        count = (count % 2 == 0) ? (count / 2) : (count / 2 + 1);
        while (count-- > 0) {
            head = head.next;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}