import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    List<String> pathList = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root != null) {
            pathBuild(root, new StringBuilder(Integer.toString(root.val)));
        }

        return pathList;
    }

    public void pathBuild(TreeNode node, StringBuilder path) {
        if (node.left == null && node.right == null) {
            pathList.add(path.toString());
            return;
        }
        if (node.left != null) {
            StringBuilder leftsb = new StringBuilder(path);
            leftsb.append("->" + node.left.val);
            pathBuild(node.left, leftsb);
        }
        if (node.right != null) {
            StringBuilder rightsb = new StringBuilder(path);
            rightsb.append("->" + node.right.val);
            pathBuild(node.right, rightsb);
        }
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
