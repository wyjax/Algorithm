class Solution {
    boolean[] check;
    boolean answer = false;

    public boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        check = new boolean[nums.length];
        check[0] = true;
        search(nums, 0);

        return answer;
    }

    public void search(int[] num, int idx) {
        if (answer) {
            return;
        }

        for (int i = num[idx]; i > 0; i--) {
            int right = idx + i;

            if (right >= num.length - 1) {
                answer = true;
                return;
            }
            if (check[right]) {
                return;
            }

            check[right] = true;
            search(num, right);
        }
    }

    public boolean canJump2(int[] nums) {
        int lastIdx = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastIdx) {
                lastIdx = i;
            }
        }

        return (lastIdx == 0);
    }
}

public class Main {
    public static void main(String[] args) {
        int[] a = {3, 2, 1, 0, 4};
        int[] b = {2, 3, 1, 1, 4};
        int[] c = {1, 3, 2};
        int[] d = {2, 0}; // true
        int[] e = {0}; // true
        int[] f = {1, 2, 3}; // true
        System.out.println(new Solution().canJump(e));
    }
}
