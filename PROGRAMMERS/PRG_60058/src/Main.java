public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("()))((()"));
    }
}

class Solution {
    public String solution(String p) {
        return sol(p);
    }

    public String sol(String p) {
        if (p.length() == 0)
            return "";

        int idx = seperate(p);
        String u = p.substring(0, idx);
        String v = p.substring(idx, p.length());

        if (isCorrect(u)) {
            return u + sol(v);
        }
        else {
            StringBuilder sb = new StringBuilder("(");
            String new_v = sol(v);
            sb.append(new_v);
            sb.append(")");

            for (int i = 1; i < u.length() - 1; i++) {
                if (u.charAt(i) == '(')
                    sb.append(')');
                else
                    sb.append('(');
            }
            return sb.toString();
        }
    }

    public int seperate(String p) {
        int cur = 0;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(')
                cur++;
            else
                cur--;
            if (cur == 0)
                return i + 1;
        }
        return p.length();
    }

    public boolean isCorrect(String u) {
        int cnt = 0;

        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(')
                cnt++;
            else
                cnt--;
            if (cnt < 0)
                return false;
        }

        if (cnt == 0)
            return true;
        return false;
    }
}
