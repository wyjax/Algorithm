import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> inter = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int num : nums1) {
            inter.put(num, inter.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2) {
            if (inter.containsKey(num)) {
                int val = inter.get(num);

                if (val == 1) {
                    inter.remove(num);
                }
                else {
                    inter.put(num, val - 1);
                }
                list.add(num);
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] a = {1, 2, 2, 1};
        int[] b = {2, 2};
        int[] a1 = {4, 9, 5};
        int[] b1 = {9, 4, 9, 8, 4};
        new Solution().intersect(a1, b1);
    }
}
