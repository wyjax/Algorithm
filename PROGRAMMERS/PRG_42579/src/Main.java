import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, ArrayList<Pair>> ans = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String song = genres[i];

            if (map.containsKey(song)) {
                int val = map.get(song);
                map.put(song, val + plays[i]);
                ans.get(song).add(new Pair(plays[i], i));
            }
            else {
                map.put(song, plays[i]);
                ArrayList<Pair> p = new ArrayList<>();
                p.add(new Pair(plays[i], i));
                ans.put(song, p);
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        ArrayList<Integer> store = new ArrayList<>();
        for (Map.Entry<String, Integer> key : list) {
            ArrayList<Pair> p = ans.get(key.getKey());
            Collections.sort(p, new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    int ret = o2.val - o1.val;
                    if (ret == 0)
                        ret = o1.idx - o2.idx;
                    return ret;
                }
            });
            if (p.size() == 1)
                store.add(p.get(0).idx);
            else {
                store.add(p.get(0).idx);
                store.add(p.get(1).idx);
            }
        }
        int[] answer = new int[store.size()];
        for (int i = 0; i < store.size(); i++)
            answer[i] = store.get(i);
        return answer;
    }

    class Pair {
        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        String[] s = {"classic", "pop", "classic", "classic", "pop"};
        int[] a = {500, 600, 150, 800, 2500};
        String[] s2 = {"a", "b", "c", "d", "e", "f"};
        int[] a2 = {1, 2, 3, 4, 5, 6};
        String[] s3 = {"b", "a", "a", "b", "c"};
        int[] a3 = {500, 500, 500, 500, 500};
        String[] s4 = {"classic", "pop", "classic", "pop", "classic", "classic"};
        int[] a4 = {400, 600, 150, 2500, 500, 500};
        String[] s5 = {"a", "a", "a"};
        int[] a5 = {300, 400, 300};
        new Solution().solution(s2, a2);
    }
}