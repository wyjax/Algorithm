
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = -1;
        int right = -1;

        if (root.left != null)
            left = minDepth(root.left);
        if (root.right != null)
            right = minDepth(root.right);

        if (left == -1 && right == -1)
            return 1;
        else if (left == -1)
            return right + 1;
        else if (right == -1)
            return left + 1;

        return Math.min(left, right) + 1;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
