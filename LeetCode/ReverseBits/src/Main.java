
class Solution {
    public int reverseBits(int n) {
        return Integer.reverse(n);
    }

    public int reverseBits2(int n) {
        boolean negative = n < 0;
        int ans = 0;
        /*
            1번  000...0001
            2번  000...0010
            3번  000...0100
         */
        for (int i = 0; i < 31; i++) {
            if ((n & 1) == 1) {
                ans++;
            }
            ans = ans << 1;
            n = n >> 1;
        }
        return (negative ? ans + 1 : ans);
    }

    /* 일부분은 맞는데 값이 커지면 틀림 */
    public int reverseBits3(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.append(n % 2);
            n /= 2;
        }
        for (int i = sb.length(); i < 32; i++) {
            sb.append(0);
        }

        String s = sb.reverse().toString();
        long answer = 0;

        for (int i = 0; i < s.length(); i++) {
            answer += (Math.pow(2, i) * (s.charAt(i) - '0'));
        }

        return (int)answer;
    }
}

// 00000000000000000000000000000001
// 10000000000000000000000000000000

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseBits2(Integer.MIN_VALUE));
//        System.out.println(new Solution().reverseBits(-123543534));
//        System.out.println(new Solution().reverseBits3(-123543534));
    }
}