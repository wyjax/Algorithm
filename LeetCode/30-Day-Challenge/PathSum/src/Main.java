class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    boolean answer = false;

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        search(root, root.val, sum);
        return answer;
    }

    public boolean hasPathSum_another(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.val == sum && root.left == null && root.right == null)
            return true;
        return (hasPathSum_another(root.left, sum - root.val)
                || hasPathSum_another(root.right, sum - root.val));

    }

    public void search(TreeNode node, int sum, int goal) {
        if (node.left == null && node.right == null) {
            if (sum == goal)
                answer = true;
        }
        if (node.left != null)
            search(node.left, sum + node.left.val, goal);
        if (node.right != null)
            search(node.right, sum + node.right.val, goal);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
