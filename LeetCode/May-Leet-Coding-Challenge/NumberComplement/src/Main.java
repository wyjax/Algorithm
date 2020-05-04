
class Solution {
    // 비트마스크 방식
    public int findComplement(int num) {
        int ans = 0, cnt = 0;

        while (num > 0) {
            int tmp = 1 - (1 & num);
            ans += (Math.pow(2, cnt) * tmp);
            cnt++;
            num >>= 1;
        }

        return ans;
    }

    // 구현 방식
    public int findComplement2(int num) {
        String v = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < v.length(); i++) {
            sb.append(1 - (v.charAt(i) - '0'));
        }
        String tmp = sb.toString();

        int ans = 0;
        int pivot = 1;

        for (int i = tmp.length() - 1; i >= 0; i--) {
            ans += (pivot * (tmp.charAt(i) - '0'));
            pivot <<= 1;
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().findComplement(8));
    }
}
