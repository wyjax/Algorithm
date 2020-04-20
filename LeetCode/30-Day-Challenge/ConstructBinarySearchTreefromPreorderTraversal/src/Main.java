
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0)
            return null;

        TreeNode root = new TreeNode(preorder[0]);

        for (int i = 1; i < preorder.length; i++) {
            int cur = preorder[i];

            TreeNode node = root;

            while (node != null) {
                if (cur < node.val) {
                    if (node.left == null) {
                        node.left = new TreeNode(cur);
                        break;
                    }
                    node = node.left;
                }
                else {
                    if (node.right == null) {
                        node.right = new TreeNode(cur);
                        break;
                    }
                    node = node.right;
                }
            }
        }

        return root;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] a = {8, 5, 1, 7, 10, 12};
        new Solution().bstFromPreorder(a);
    }
}
