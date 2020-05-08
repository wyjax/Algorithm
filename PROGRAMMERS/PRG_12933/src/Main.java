import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public long solution(long n) {
        String s = Long.toString(n);
        int len = s.length();
        char []c = s.toCharArray();
        Arrays.sort(c);
        s = "";
        for(int i = c.length - 1; i >= 0; i--) {
            s += c[i];
        }
        System.out.println(s);
        return Long.parseLong(s);
    }
}

public class Main {
    public static void main(String[] args) {
        new Solution().solution(118372);
    }
}
