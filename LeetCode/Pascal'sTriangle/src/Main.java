import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        if (numRows == 0) {
            return list;
        }

        list.add(new ArrayList<>());
        list.get(0).add(1);

        for (int i = 0; i < numRows - 1; i++) {
            list.add(new ArrayList<>());
            List<Integer> cur = list.get(i);

            for (int j = 0; j < cur.size() - 1; j++) {
                list.get(i + 1).add(cur.get(j) + cur.get(j + 1));
            }

            list.get(list.size() - 1).add(0, 1);
            list.get(list.size() - 1).add(1);
        }
        return list;
    }
}

public class Main {
    public static void main(String[] args) {
        new Solution().generate(5);
    }
}
