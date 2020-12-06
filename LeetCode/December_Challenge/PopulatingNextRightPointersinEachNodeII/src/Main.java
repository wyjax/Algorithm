import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class Solution {
    List<Node> nodes = new ArrayList<>();

    public Node connect(Node root) {
        solution(root, 0);

        return root;
    }

    public void solution(Node node, int depth) {
        if (node == null) {
            return;
        }
        if (depth >= nodes.size()) {
            nodes.add(node);
        }
        else {
            nodes.get(depth).next = node;
            nodes.set(depth, node);
        }
        solution(node.left, depth + 1);
        solution(node.right, depth + 1);
    }
}

public class Main {

}
