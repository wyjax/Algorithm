
class Trie {
    private Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node(' ');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = root;

        for (char c : word.toCharArray()) {
            Node next = node.nodes[c - 'a'];

            if (next == null) {
                next = new Node(c);
                node.nodes[c - 'a'] = next;
            }
            node = next;
        }
        node.end = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = root;

        for (char c : word.toCharArray()) {
            node = node.nodes[c - 'a'];

            if (node == null) {
                return false;
            }
        }
        return node.end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = root;

        for (char c : prefix.toCharArray()) {
            node = node.nodes[c - 'a'];
            if (node == null) {
                return false;
            }
        }
        return true;
    }

    private class Node {
        char ch;
        Node[] nodes;
        boolean end;

        public Node(char ch) {
            this.ch = ch;
            this.nodes = new Node[26];
        }
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
