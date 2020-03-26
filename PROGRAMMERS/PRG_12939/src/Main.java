class Solution {
    public String solution(String s) {
        String[] a = s.split(" ");
        int maxs = Integer.MIN_VALUE;
        int mins = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {
            int cur = Integer.parseInt(a[i]);
            maxs = Math.max(cur, maxs);
            mins = Math.min(cur, mins);
        }
        String answer = Integer.toString(mins) + " " + Integer.toString(maxs);
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
