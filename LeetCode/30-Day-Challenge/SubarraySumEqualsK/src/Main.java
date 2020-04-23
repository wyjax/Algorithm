import java.util.HashMap;

class Solution {
    public int subarraySum2(int[] nums, int k) {
        int answer = 0;
        int[] sums = new int[nums.length + 1];

        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (sums[i] - sums[j] == k) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        int answer = 0;
        int sum = 0;
        cache.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (cache.containsKey(sum - k)) {
                answer += cache.get(sum - k);
            }

            cache.put(sum, cache.getOrDefault(sum, 0) + 1);
        }

        return answer;
    }
    // 3 4 2 6    6
    // 3 7 9 15
    /*
        3 - 6
        7 - 6
        9 - 6 = 3
     */
}

public class Main {
    public static void main(String[] args) {
        int[] a = {1, 1, 1};
        new Solution().subarraySum(a, 2);
    }
}
