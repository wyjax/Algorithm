

class Solution {
    int answer = 0;
    boolean[] check;

    public int solution(String begin, String target, String[] words) {
        check = new boolean[words.length];
        answer = words.length + 1;
        search(begin, target, 0, words);

        if (answer == words.length + 1)
            answer = 0;
        return answer;
    }

    public void search(String cur, String target, int sum, String[] words) {
        if (cur.equals(target)) {
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (check[i]) continue;
            if (isUse(cur, words[i])) {
                if (sum + 1 > answer) continue;

                check[i] = true;
                search(words[i], target, sum + 1, words);
                check[i] = false;
            }
        }
    }

    public boolean isUse(String a, String b) {
        int answer = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) continue;
            answer++;
            if (answer > 1)
                return false;
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        String a = "hit";
        String b = "cog";
        String[] c = {"hot", "dot", "dog", "lot", "log", "cog"};
        new Solution().solution(a, b, c);
    }
}
