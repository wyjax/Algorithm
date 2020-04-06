public class Main {
    public static void main(String[] args) {
        int[] a = {0, 1, 0, 3, 12};
        new Solution().moveZeroes(a);
        /*
            Input: [0,1,0,3,12]
            Output: [1,3,12,0,0]
         */
    }
}

class Solution {
    public void moveZeroes(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            // 0이 아닌 부분을 0부터 채워넣는다.
            if (nums[i] != 0)
                nums[idx++] = nums[i];
        }
        // 남는 곳은 0으로 모두 채운다.
        while (idx < nums.length)
            nums[idx++] = 0;
    }
}