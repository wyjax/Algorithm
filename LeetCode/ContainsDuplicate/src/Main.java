import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class Solution {

    // 7ms
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1])
                return true;
        }
        return false;
    }

    // 15ms
    public boolean containsDuplicate2(int[] nums) {
        HashSet<Integer> numBox = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (numBox.contains(nums[i])) {
                return true;
            }
            numBox.add(nums[i]);
        }
        return false;
    }

    // 18ms
    public boolean containsDuplicate3(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            }
            map.put(nums[i], true);
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1};
        System.out.println(new Solution().containsDuplicate(a));
    }
}
