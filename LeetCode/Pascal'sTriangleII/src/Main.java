import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);

        while (rowIndex-- > 0) {
            List<Integer> newList = new ArrayList<>();

            for (int j = 0; j < list.size() - 1; j++) {
                newList.add(list.get(j) + list.get(j + 1));
            }
            newList.add(0, 1);
            newList.add(1);
            list = newList;
        }

        return list;
    }
}

public class Main {
    public static void main(String[] args) {
        new Solution().getRow(2);
    }
}
