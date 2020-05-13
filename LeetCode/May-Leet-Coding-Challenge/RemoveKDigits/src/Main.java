
class Solution {
    public String removeKdigits(String num, int k) {
        for (int i = 1; i <= k; i++)
            num = toRemoveOneDigit(num);
        return num;
    }

    private String toRemoveOneDigit(String num) {
        int length = num.length();
        int index = length - 1;
        for (int i = 0; i < index; i++) {
            if (num.charAt(i) > num.charAt(i + 1)) {
                index = i;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char digit = num.charAt(i);
            if (sb.length() == 0 && digit == '0' || i == index)
                continue;
            sb.append(digit);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
