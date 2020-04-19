
class Solution {
    public int trailingZeroes(int n) {
        int count = 0;

        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }

        return count;
    }
}

// 5 10 15 20 25 30

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().trailingZeroes(24));
    }
}

// 5 10 15 20 25 30