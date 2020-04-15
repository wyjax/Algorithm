

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int cnt = 1;
        int cur = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (cur == nums[i]) continue;
            nums[cnt++] = nums[i];
            cur = nums[i];
        }
        return cnt;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] a = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(new Solution().removeDuplicates(a));
    }
}
