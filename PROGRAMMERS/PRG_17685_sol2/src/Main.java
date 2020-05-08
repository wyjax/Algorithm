public class Main {
    public static void main(String[] args) {
        String[] s1 = {"go", "gone", "guild"};
        System.out.println(new Solution().solution(s1));
    }
}

class Solution {
    public int solution(String[] words) {
        int answer = 0;
        Trie root = new Trie();
        Trie node;

        for (int i = 0; i < words.length; i++) {
            node = root;
            for (int j = 0; j < words[i].length(); j++) {
                int idx = words[i].charAt(j) - 'a';
                if (node.child == null) {
                    node.child = new Trie[26];
                    node.count = new int[26];
                }
                if (node.child[idx] == null) {
                    node.child[idx] = new Trie();
                    node.count[idx] = 1;
                }
                else {
                    node.count[idx]++;
                }
                node = node.child[idx];
            }
        }

        for (int i = 0; i < words.length; i++) {
            node = root;
            for (int j = 0; j < words[i].length(); j++) {
                int idx = words[i].charAt(j) - 'a';
                answer++;
                if (node.count[idx] == 1)
                    break;
                else
                    node = node.child[idx];
            }
        }
        return answer;
    }

    class Trie {
        Trie[] child;
        int[] count;
    }
}