import java.util.HashSet;
import java.util.Set;

class Solution {
    public int distributeCandies(int[] candyType) {
        int maximumEat = candyType.length / 2;
        Set<Integer> candySet = new HashSet<>();

        for (int candy : candyType) {
            candySet.add(candy);

            if (candySet.size() >= maximumEat) {
                break;
            }
        }
        /*
            결과값은 사탕개수 / 2와 종류수 중에 작은 값이 답이다.
         */

        return Math.min(maximumEat, candySet.size());
    }
}
