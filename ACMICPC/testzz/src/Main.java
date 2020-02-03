import java.util.*;

class Solution {
    Set<String> set;
    HashMap<String, Integer> ans;

    public String[] solution(String[][] f, String user_id) {
        set = new HashSet<>();
        ans = new HashMap<>();

        for (int i = 0; i < f.length; i++) {
            if (user_id.equals(f[i][0]))
                set.add(f[i][1]);
            else if (user_id.equals(f[i][1]))
                set.add(f[i][0]);
        }

        for (int i = 0; i < f.length; i++) {
            for (String str : set) {
                if (f[i][0].equals(user_id) || f[i][1].equals(user_id)) continue;
                if (str.equals(f[i][0])) {
                    int num = (ans.get(f[i][1]) == null) ? 1 : ans.get(f[i][1]) + 1;
                    ans.put(f[i][1], num);
                }
                else if (str.equals(f[i][1])) {
                    int num = (ans.get(f[i][0]) == null) ? 1 : ans.get(f[i][0]) + 1;
                    ans.put(f[i][0], num);
                }
            }
        }

        List<String> list = new ArrayList<>(ans.keySet());
        Collections.sort(list, (o1, o2) -> (ans.get(o2).compareTo(ans.get(o1))));

        ArrayList<String> anslist = new ArrayList<>();
        int maxs = 0;
        for (String s : list) {
            if (maxs < ans.get(s))
                maxs = ans.get(s);
            if (maxs > ans.get(s))
                break;
            anslist.add(s);
        }
        Collections.sort(anslist);
        String[] answer = anslist.toArray(new String[anslist.size()]);

        return answer;
    }
}