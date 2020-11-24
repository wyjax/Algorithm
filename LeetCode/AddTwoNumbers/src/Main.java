class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return sum(l1, l2, 0);
    }

    public ListNode sum(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            return (carry == 0) ? null : new ListNode(carry);
        }
        if (l1 == null) {
            int sum = (carry + l2.val);
            int value = sum % 10;
            carry = sum / 10;
            ListNode curNode = new ListNode(value);
            curNode.next = sum(l1, l2.next, carry);

            return curNode;
        }
        if (l2 == null) {
            int sum = (carry + l1.val);
            int value = sum % 10;
            carry = sum / 10;
            ListNode curNode = new ListNode(value);
            curNode.next = sum(l1.next, l2, carry);

            return curNode;
        }

        int val = (l1.val + l2.val + carry) % 10;
        carry = (l1.val + l2.val + carry) / 10;
        ListNode cur = new ListNode(val);
        cur.next = sum(l1.next, l2.next, carry);
        return cur;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}