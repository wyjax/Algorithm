import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < n; i++) {
            sb.append(sc.next());
        }
        new Solution().solution(sb.toString());
    }
}

class Solution {
    String s;
    int len;
    String max = "00000000000";
    String min = "99999999999";
    boolean[] check = new boolean[10];

    public void solution(String s) {
        len = s.length();
        this.s = s;

        for (int i = 0; i < 10; i++) {
            check[i] = true;
            solve(1, Integer.toString(i));
            check[i] = false;
        }

        System.out.println(max);
        System.out.println(min);
    }

    public void solve(int cnt, String ss) {
        if (cnt == len + 1) {
            if (max.compareTo(ss) < 0)
                max = ss;
            if (min.compareTo(ss) > 0)
                min = ss;
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (check[i])
                continue;

            if (s.charAt(cnt - 1) == '>') {
                if (ss.charAt(ss.length() - 1) < (char) (i + '0'))
                    continue;
            } else if (s.charAt(cnt - 1) == '<') {
                if (ss.charAt(ss.length() - 1) > (char) (i + '0'))
                    continue;
            }

            check[i] = true;
            solve(cnt + 1, ss + Integer.toString(i));
            check[i] = false;
        }
    }
}