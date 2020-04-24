
class Solution {
    public boolean isPowerOfFour(int num) {
        if (num < 1)
            return false;

        while (num > 1) {
            if (num % 4 != 0)
                return false;

            num /= 4;
        }

        return (num == 1);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfFour(16));
    }
}
