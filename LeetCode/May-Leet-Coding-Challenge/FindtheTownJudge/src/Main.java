import java.util.HashMap;
import java.util.HashSet;

class Solution {
    // run : 15ms
    public int findJudge(int N, int[][] trust) {
        if (N <= 1) {
            return 1;
        }

        int[] to = new int[N + 1];
        int[] from = new int[N + 1];

        for (int i = 0; i < trust.length; i++) {
            from[trust[i][1]]++;
            to[trust[i][0]]++;
        }

        for (int i = 1; i <= N; i++) {
            if (to[i] == 0 && from[i] == (N - 1)) {
                return i;
            }
        }

        return -1;
    }
    // run : 19 ms
    public int findJudge2(int N, int[][] trust) {
        HashMap<Integer, HashSet<Integer>> box = new HashMap<>();
        int cnt = -1;
        int idx = -1;

        for (int i = 0; i < trust.length; i++) {
            int to = trust[i][0];
            int from = trust[i][1];

            HashSet<Integer> tmp = box.getOrDefault(from, new HashSet<>());
            tmp.add(to);

            if (cnt < tmp.size()) {
                cnt = tmp.size();
                idx = from;
            }
            box.put(from, tmp);
        }

        if (cnt == N - 1) {
            for (int i = 0; i < trust.length; i++) {
                if (idx == trust[i][0])
                    return -1;
            }
            return idx;
        }
        if (N == 1)
            return 1;
        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] a = {{1,2}};
        System.out.println(new Solution().findJudge(2, a));
    }
}
