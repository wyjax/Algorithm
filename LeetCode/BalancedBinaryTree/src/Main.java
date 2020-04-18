

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    boolean check = true;

    public boolean isBalanced(TreeNode root) {
        return (search(root) != -1);
    }

    public int search(TreeNode node) {
        if (node == null)
            return 0;

        int leftLevel = search(node.left);
        int rightLevel = search(node.right);

        if (leftLevel == -1 || rightLevel == -1)
            return -1;
        if (Math.abs(leftLevel - rightLevel) > 1)
            return -1;

        return Math.max(leftLevel, rightLevel) + 1;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
