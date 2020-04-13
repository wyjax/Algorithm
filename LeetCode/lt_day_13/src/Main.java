import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0, maxLen = 0;
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            count += (nums[i] == 0) ? -1 : 1;

            if (map.containsKey(count))
                maxLen = Math.max(maxLen, i - map.get(count));
            else
                map.put(count, i);
        }
        return maxLen;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] a = {0, 1};
        System.out.println(new Solution().findMaxLength(a));
    }
}

