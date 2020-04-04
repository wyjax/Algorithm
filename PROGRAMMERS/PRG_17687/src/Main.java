

class Solution {
    public String solution(int n, int t, int m, int p) {
        // 진법  숫자의 개수  인원  순서
        StringBuilder sb = new StringBuilder("0");
        for (int i = 0; i <= t * m; i++) {
            sb.append(convert(i, n));
        }
        char[] a = sb.toString().toCharArray();
        StringBuilder ans = new StringBuilder();

        int count = 0;
        for (int i = p - 1; count < t; i += m, count++) {
            ans.append(a[i]);
        }

        return ans.toString();
    }

    public String convert(int n, int gubun) {
        StringBuilder sb = new StringBuilder();
        // 110

        while (n > 1) {
            int tmp = n % gubun;

            if (tmp > 9) {
                if (tmp == 10)
                    sb.append("A");
                else if (tmp == 11)
                    sb.append("B");
                else if (tmp == 12)
                    sb.append("C");
                else if (tmp == 13)
                    sb.append("D");
                else if (tmp == 14)
                    sb.append("E");
                else if (tmp == 15)
                    sb.append("F");
            }
            else
                sb.append(tmp);
            n = n / gubun;
        }
        if (n > 0)
            sb.append(n);

        return sb.reverse().toString();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(16, 16, 2, 1));
    }
}

/*
02468ACE11111111
13579BDF01234567

 */