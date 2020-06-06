import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[0] == o1[0]) {
                    return o1[1] - o2[1];
                }
                else {
                    return o2[0] - o1[0];
                }
            }
        });
        /*
            현재 사람이 출력 배열에 삽입되는 것을 고려하자
            그가 사입된 가장 작은 사람이므로 k 위치에 간단하게
            삽입된다. 삽입되는 사람은 이미 들어간 사람들보다
            키가 작기 때문에 삽입되는 위치는 이전에 삽입된
            사람들의 k값에 영향을 미치지 않는다.
         */

        List<int[]> ans = new ArrayList<>();

        for (int[] person : people) {
            ans.add(person[1], person);
        }
        int n = people.length;

        return ans.toArray(new int[n][2]);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
