
class Solution {
    public boolean isPowerOfThree2(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return (n == 1);
    }

    public boolean isPowerOfThree(int n) {
        String bit = Integer.toString(n, 3);


        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        new Solution().isPowerOfThree(27);
    }
}
