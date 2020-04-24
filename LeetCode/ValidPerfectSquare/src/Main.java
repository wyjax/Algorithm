
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 0 || num == 1)
            return true;

        long left = 1;
        long right = num;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long pow = (mid * mid);

            if (pow < num) {
                left = mid + 1;
            }
            else if (pow > num) {
                right = mid - 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        new Solution().isPerfectSquare(2147483647);
    }
}
