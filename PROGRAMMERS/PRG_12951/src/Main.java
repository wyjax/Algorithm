

class Solution {
    public String solution(String s) {
        String[] a = s.split(" ");

        StringBuilder sb = new StringBuilder();
        boolean check = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                check = true;
                sb.append(c);
            }
            else {
                if (check) {
                    sb.append(Character.toUpperCase(c));
                    check = false;
                }
                else
                    sb.append(Character.toLowerCase(c));
            }
        }

        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
