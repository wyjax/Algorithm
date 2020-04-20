
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode invertTree(TreeNode root) {
        TreeNode node = root;
        invert(root);

        return node;
    }

    public void invert(TreeNode node) {
        if (node == null)
            return;

        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;

        invert(node.left);
        invert(node.right);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
