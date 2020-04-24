import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int goal = nums.length / 2 + 1;

        for (int i = 0; i < nums.length; i++) {
            int count = 1;

            if (map.containsKey(nums[i])) {
                count = map.get(nums[i]) + 1;
                map.put(nums[i], count);
            }
            else {
                map.put(nums[i], 1);
            }

            if (count >= goal)
                return nums[i];
        }

        return 0;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
