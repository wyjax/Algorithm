import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public static int[] solution(String msg) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 26; i++)
            map.put(Character.toString((char) ('A' + i)), i + 1);

        int idx = 0, next_idx = 27;
        while (idx < msg.length()) {
            String cur = Character.toString(msg.charAt(idx));

            int cnt = 0, val = 0;
            while (map.containsKey(cur)) {
                val = map.get(cur);

                if (idx + (++cnt) >= msg.length())
                    break;
                cur += Character.toString(msg.charAt(idx + cnt));
            }
            list.add(val);
            map.put(cur, next_idx++);
            idx += cnt;
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++)
            answer[i] = list.get(i);

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        String a = "KAKAO";
        String b = "TOBEORNOTTOBEORTOBEORNOT";
        new Solution().solution(a);
    }
}