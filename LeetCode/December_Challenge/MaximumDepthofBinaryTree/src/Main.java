import java.util.Optional;

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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(recursive(root.left, 1), recursive(root.right, 1));
    }

    public int recursive(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }

        return Math.max(recursive(node.left, depth + 1), recursive(node.right, depth + 1));
    }
}

public class Main {
}
