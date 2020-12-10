class Solution {
    private static final int SIXTY = 60;

    public int numPairsDivisibleBy60(int[] time) {
        int[] times = new int[SIXTY];
        int result = 0;

        for (int t : time) {
            if (t % SIXTY == 0) {
                result += times[0];
            }
            else {
                result += times[SIXTY - (t % SIXTY)];
            }
            times[t % SIXTY]++;
        }

        return result;
    }
}

public class Main {

}
