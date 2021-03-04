class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    /*
        Runtime: 1 ms
        Memory Usage: 42.2 MB

        solution : 겹치는 부분들은 공통된 부분이다. 그래서 공통되는 부분이 있으면 남은 길이는 같다 그렇기 때문에 남은 길이가
        같은 상태에서 next를 통해서 같은 노드를 찾는다.
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLen = getLengthForListNode(headA, 0);
        int bLen = getLengthForListNode(headB, 0);

        while (aLen != bLen) {
            if (aLen > bLen) {
                aLen--;
                headA = headA.next;
            }
            else {
                bLen--;
                headB = headB.next;
            }
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    private int getLengthForListNode(ListNode node, int len) {
        if (node == null) {
            return len;
        }

        return getLengthForListNode(node.next, len + 1);
    }

    /*
        Runtime: 1 ms
        Memory Usage: 41.5 MB

        이건 천재가 한 듯 딱봐도 코드포스 오렌지종족들이 짤만한 코드
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            if (a == null) {
                a = headB;
            }
            else {
                a = a.next;
            }

            if (b == null) {
                b = headA;
            }
            else {
                b = b.next;
            }
        }

        return a;
    }
}
