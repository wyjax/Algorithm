public class Main {
    public static void main(String[] args) {

    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        search(root);
        return max;
    }

    public int search(TreeNode root) {
        if (root == null)
            return 0;

        int left = search(root.left);
        int right = search(root.right);
        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/*
public class Solution {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        max = Math.max(max, helper(root.left) + helper(root.right));
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return max;
    }
    public int helper(TreeNode root){
        if(root == null)
            return 0;
        return 1 + Math.max(helper(root.left), helper(root.right));
    }
}
 */