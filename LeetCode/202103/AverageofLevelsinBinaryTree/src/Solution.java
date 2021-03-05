import java.util.ArrayList;
import java.util.List;

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
    private List<Double> avg = new ArrayList<>();
    private List<Integer> count = new ArrayList<>();

    /*
        Runtime: 1 ms
        Memory Usage: 40.7 MB
     */
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return avg;
        }

        find(root, 0);
        int size = avg.size();

        for (int i = 0; i < size; i++) {
            int cnt = count.get(i);
            double val = avg.get(i) / (double) cnt;

            avg.set(i, val);
        }

        return avg;
    }

    private void find(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        if (level == avg.size()) {
            avg.add((double) node.val);
            count.add(1);
        }
        else {
            double value = avg.get(level) + (double) node.val;
            avg.set(level, value);
            count.set(level, count.get(level) + 1);
        }

        find(node.left, level + 1);
        find(node.right, level + 1);
    }
}
