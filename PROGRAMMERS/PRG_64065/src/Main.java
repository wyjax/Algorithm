import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;

class Solution {
    public int[] solution(String s) {
        s = s.substring(1, s.length() - 1);
        s = s.replaceAll(",\\{", "={");
        String[] a = s.split("=");

        Arrays.sort(a, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.split(",").length - o2.split(",").length;
            }
        });
        HashSet<Integer> set = new LinkedHashSet<>();
        for (String str : a) {
            str = str.replace('{', ' ');
            str = str.replace('}', ' ');

            for (String i : str.split(","))
                set.add(Integer.parseInt(i.trim()));
        }

        int idx = 0;
        int[] answer = new int[set.size()];
        for (int num : set) {
            answer[idx++] = num;
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        new Solution().solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
    }
}
