public class Main {
    public static void main(String[] args) {
        new Solution().solution("I love you");
    }
}

class Solution {
    char alpha[] = {'Z','Y','X','W','V','U','T','S','R','Q','P',
            'O','N','M','L','K','J','I','H','G','F','E','D','C','B','A'};

    public String solution(String s) {
        StringBuilder sb = new StringBuilder("");

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isLowerCase(c))
                c = Character.toLowerCase(alpha[c - 'a']);
            else if (Character.isUpperCase(c))
                c = alpha[c - 'A'];
            sb.append(c);
        }

        System.out.println(sb.toString());
        return sb.toString();
    }
}