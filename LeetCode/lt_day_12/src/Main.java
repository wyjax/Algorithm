import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int n : stones)
            q.add(n);

        while (q.size() > 1) {
            int y = q.remove();
            int x = q.remove();

            if (x != y)
                q.add(y - x);
        }
        return (q.size() > 0 ? q.remove() : 0);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
