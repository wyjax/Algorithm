

public class Solution {
    public int firstBadVersion(int n) {
        if (n == 0) {
            return -1;
        }

        int left = 1;
        int right = n;
        int mid = 0;

        while (left < right) {
            mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid;
            }
            else if (!isBadVersion(mid)) {
                left = mid + 1;
            }
        }

        return left;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}

/*
    2 + 5 = 7 / 2 > 3
    2 + (5 - 2) / 2 > 3
 */