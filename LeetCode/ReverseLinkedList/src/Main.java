import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        // 2ms
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(0, head.val);
            head = head.next;
        }

        ListNode root = new ListNode(-1);
        ListNode node = root;

        for (int num : list) {
            node.next = new ListNode(num);
            node = node.next;
        }

        return root.next;
    }
    // 0ms
    public ListNode reverseList2(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode ref;

        while (cur != null) {
            ref = cur.next;
            cur.next = pre;
            pre = cur;
            cur = ref;
        }

        return pre;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
