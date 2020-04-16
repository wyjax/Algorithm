

class Solution {
    public int mySqrt(int x) {
        int left = 1, right = x / 2;

        if (x == 0)
            return 0;
        else if (left > right)
            return left;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int test = x / mid;

            if (test < mid)
                right = mid - 1;
            else if (test > mid)
                left = mid + 1;
            else
                return mid;
        }
        return right;
//        return Math.sqrt(x);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(1523747273));
    }
}

// 4 10    4 + (6)