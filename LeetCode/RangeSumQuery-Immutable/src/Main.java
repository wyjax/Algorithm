
class NumArray {
    int[] sums;
    int[] segment;

    public NumArray(int[] nums) {
        sums = new int[nums.length + 1];

        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange2(int i, int j) {
        return (sums[j] - sums[i - 1]);
    }
}

public class Main {
    public static void main(String[] args) {
        int[] a = {-2, 0, 3, -5, 2, -1};
        new NumArray(a);
    }
}


/*
["NumArray","sumRange","sumRange","sumRange"]
[[[-2,0,3,-5,2,-1]],[0,2],[2,5],[0,5]]
 */