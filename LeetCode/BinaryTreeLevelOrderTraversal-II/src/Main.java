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
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        search(root, 0);
        return list;
    }

    public void search(TreeNode node, int level) {
        if (node == null)
            return;
        // 해당 레벨에 리스트가 없으면 생성
        if (list.size() == level)
            list.add(0, new ArrayList<>());

        search(node.left, level + 1);
        search(node.right, level + 1);

        // 해당 레벨에 삽입
        list.get(list.size() - level - 1).add(node.val);
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(4);
        TreeNode root4 = new TreeNode(5);

        root.left = root1;
        root1.left = root3;
        root.right = root2;
        root2.right = root4;

        new Solution().levelOrderBottom(root);
    }
}
