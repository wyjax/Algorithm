

class Solution {
    public int romanToInt(String s) {
        int idx = 0;
        int answer = 0;

        while (idx < s.length()) {
            int cur = convert(s.charAt(idx++));

            if (idx < s.length() && cur < convert(s.charAt(idx)))
                cur = convert(s.charAt(idx++)) - cur;
            answer += cur;
        }
        return answer;
    }

    public int convert(char c) {
        if (c == 'I')
            return 1;
        else if (c == 'V')
            return 5;
        else if (c == 'X')
            return 10;
        else if (c == 'L')
            return 50;
        else if (c == 'C')
            return 100;
        else if (c == 'D')
            return 500;
        else
            return 1000;
    }
}

public class Main {
    public static void main(String[] args) {
        String a = "III";
        String b = "IV";
        String c = "IX";
        String d = "LVIII";
        String e = "MCMXCIV";
        System.out.println(new Solution().romanToInt(e));
    }
}
