import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().backspaceCompare("ab#c", "ad#c"));
    }
}

class Solution {
    public boolean backspaceCompare(String S, String T) {
        return convert(S).equals(convert(T));
    }

    public String convert(String s) {
        Stack<Character> q = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char next = s.charAt(i);
            if (next == '#') {
                if (q.size() > 0)
                    q.pop();
            }
            else {
                q.push(next);
            }
        }
        return String.valueOf(q);
    }
}

/*
    ab#c > ac
    ad#c > ac

    ab## > ""
    c#d# > ""

    a##c > c
    #a#c > c
 */