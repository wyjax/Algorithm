
public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] arr = new int[nums.length];
        int[] ret = new int[2];

        for (int n : nums) {
            arr[n - 1]++;
        }

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 0) {
                ret[1] = i + 1;
            }
            else if (arr[i] > 1) {
                ret[0] = i + 1;
            }

            if (ret[0] > 0 && ret[1] > 0) {
                break;
            }
        }

        return ret;
    }
}
