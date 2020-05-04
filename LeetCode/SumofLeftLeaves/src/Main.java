
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        int ret = 0;

        if (root == null) {
            return 0;
        }
        if (root.left != null) {
            ret += sumOfLeftLeaves(root.left);

            if (root.left.left == null && root.left.right == null) {
                ret += root.left.val;
            }
        }
        if (root.right != null) {
            ret += sumOfLeftLeaves(root.right);
        }
        return ret;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
