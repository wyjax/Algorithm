class Solution {
    public boolean isPowerOfTwo(int n) {

        int idx = 0;
        while (true) {
            long a = (long) Math.pow(2, idx);

            if (a == n)
                return true;
            if (a > n)
                return false;
            idx++;
        }
    }

    // bitCount >> 2 진법으로 변환하고 1의 개수를 반환한다. 1개가 있으면 무조건 2의 제곱수
    public boolean isPowerOfTwo2(int n) {
        if (n < 0)
            return false;
        return (Integer.bitCount(n) == 1);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfTwo(2));
    }
}
