import java.util.HashMap;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int idx = map.get(nums[i]);

                if (i - idx <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }

        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1};
        int[] b = {1, 0, 1, 1};
        int[] c = {1, 2, 3, 1, 2, 3};
        System.out.println(new Solution().containsNearbyDuplicate(a, 3));
        System.out.println(new Solution().containsNearbyDuplicate(b, 1));
        System.out.println(new Solution().containsNearbyDuplicate(c, 2));
    }
}
