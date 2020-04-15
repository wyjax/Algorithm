import java.util.StringTokenizer;

class Solution {
    public int lengthOfLastWord(String s) {
        StringTokenizer st = new StringTokenizer(s);
        String answer = "";

        while (st.hasMoreTokens()) {
            answer = st.nextToken();
        }
        return answer.trim().length();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLastWord("Hello World"));
    }
}
