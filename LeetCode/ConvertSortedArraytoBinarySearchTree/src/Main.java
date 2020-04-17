
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;

        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] num, int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;
        TreeNode parent = new TreeNode(num[mid]);
        parent.left = sortedArrayToBST(num, start, mid - 1);
        parent.right = sortedArrayToBST(num, mid + 1, end);

        return parent;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
