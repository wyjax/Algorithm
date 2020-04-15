class Solution {
    public int removeElement(int[] nums, int val) {
        int answer = nums.length;
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (val == nums[i]) continue;
            nums[idx++] = nums[i];
        }

        return idx;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}

// 3 2 2 3 / val = 3
// 0부터 시작해서 2 2