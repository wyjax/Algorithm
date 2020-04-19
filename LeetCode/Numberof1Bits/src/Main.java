
class Solution {
    public int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                count++;
        }

        return count;
    }

    public int hammingWeight2(int n) {
        int count = 0;

        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }

        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(-3));
        System.out.println(new Solution().hammingWeight2(-3));
    }
}
