
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
    boolean answer = false;

    public boolean isValidSequence(TreeNode root, int[] arr) {
        search(root, 0, arr);
        return answer;
    }

    public void search(TreeNode node, int idx, int[] arr) {
        if (idx == arr.length - 1 && node.val == arr[idx]) {
            if (node.left == null && node.right == null) {
                answer = true;
            }
            return;
        }
        if (node.val == arr[idx]) {
            if (node.left != null)
                search(node.left, idx + 1, arr);
            if (node.right != null)
                search(node.right, idx + 1, arr);
        }
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
