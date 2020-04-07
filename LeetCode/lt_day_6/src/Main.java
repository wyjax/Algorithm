import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] a = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new Solution().groupAnagrams(a));
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String s1 : strs) {
            char[] arr = new char[26];
            for (int i = 0; i < s1.length(); i++)
                arr[s1.charAt(i) - 'a']++;

            String s2 = new String(arr);

            if (map.containsKey(s2))
                map.get(s2).add(s1);
            else {
                ArrayList<String> list = new ArrayList<>();
                list.add(s1);
                map.put(s2, list);
            }
        }

        ans.addAll(map.values());
        return ans;
    }
}