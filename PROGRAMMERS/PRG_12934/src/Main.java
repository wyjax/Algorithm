

class Solution {
    public long solution(long n) {
        double val = Math.sqrt(n);

        if (val > Math.floor(val))
            return -1;
        long answer = (long) val + 1;

        return answer * answer;
    }
}

public class Main {
    public static void main(String[] args) {
        new Solution().solution(121);
    }
}
