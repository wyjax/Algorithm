import java.util.ArrayList;

class Solution {
    public String addBinary(String a, String b) {
        int len = Math.min(a.length(), b.length());

        ArrayList<Character> list = new ArrayList<>();
        int carry = 0;
        for (int i = 1; i <= len; i++) {
            char c1 = a.charAt(a.length() - i);
            char c2 = b.charAt(b.length() - i);

            carry = (c1 - '0') + (c2 - '0') + carry;
            list.add(0, (char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (a.length() > b.length()) {
            for (int i = a.length() - len - 1; i >= 0; i--) {
                char c = a.charAt(i);
                carry = (c - '0') + carry;
                list.add(0, (char) (carry % 2 + '0'));
                carry /= 2;
            }
        }
        else if (a.length() < b.length()) {
            for (int i = b.length() - len - 1; i >= 0; i--) {
                char c = b.charAt(i);
                carry = (c - '0') + carry;
                list.add(0, (char) (carry % 2 + '0'));
                carry /= 2;
            }
        }
        if (carry == 1)
            list.add(0, '1');
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(new Solution().addBinary(a, b));
    }
}
