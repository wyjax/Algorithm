class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder("");

        while (n-- > 0) {
            sb.append((char) ((n % 26) + 'A'));
            n /= 26;
        }

        return sb.reverse().toString();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().convertToTitle(701));
    }
}

/*
    26 Z
    27 AA
 */