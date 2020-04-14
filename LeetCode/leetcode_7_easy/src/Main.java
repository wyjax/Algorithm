
class Solution {
    public int reverse(int x) {
        long answer = 0;
        StringBuilder sb = new StringBuilder();
        boolean minus = (x < 0) ? true : false;

        if (minus)
            x *= -1;
        while (x > 0) {
            int tmp = x % 10;
            answer = answer * 10 + tmp;
            x /= 10;

            if (answer > Integer.MAX_VALUE || answer < Integer.MIN_VALUE)
                return 0;
        }
        if (minus)
            answer = -answer;

        return (int)answer;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().reverse(-120));
    }
}
