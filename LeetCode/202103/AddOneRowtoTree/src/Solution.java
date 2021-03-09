
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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        TreeNode tmp = root;

        if (d == 1) {
            TreeNode newNode = new TreeNode(v);
            newNode.left = root;

            return newNode;
        }

        go(tmp, v, d, 1);

        return root;
    }

    private void go(TreeNode node, int v, int d, int level) {
        if (node == null) {
            return;
        }

        if (level == d - 1) {
            TreeNode left = node.left;
            TreeNode right = node.right;

            TreeNode newLeft = new TreeNode(v);
            newLeft.left = left;
            node.left = newLeft;
            TreeNode newRight = new TreeNode(v);
            newRight.right = right;
            node.right = newRight;

            return;
        }

        go(node.left, v, d, level + 1);
        go(node.right, v, d, level + 1);
    }
}
