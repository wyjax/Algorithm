import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class Solution {
    boolean[] visited;
    Set<String> set = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        search(new TreeSet<>(), user_id, banned_id, 0);

        return set.size();
    }

    public void search(Set<String> ban, String[] user_id, String[] banned_id, int idx) {
        if (ban.size() == banned_id.length) {
            if (set.contains(ban.toString())) {
                return;
            }

            set.add(ban.toString());
            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (isUser(banned_id[idx], user_id[i])) {
                visited[i] = true;
                ban.add(user_id[i]);
                search(ban, user_id, banned_id, idx + 1);
                ban.remove(user_id[i]);
                visited[i] = false;
            }
        }
    }

    public boolean isUser(String banned_id, String user_id) {
        if (banned_id.length() != user_id.length()) {
            return false;
        }

        for (int i = 0; i < banned_id.length(); i++) {
            if (banned_id.charAt(i) == '*') {
                continue;
            }
            if (banned_id.charAt(i) != user_id.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        String[] a1 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] b1 = {"fr*d*", "abc1**"};
        String[] a2 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] b2 = {"*rodo", "*rodo", "******"};
        String[] a3 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] b3 = {"fr*d*", "*rodo", "******", "******"};

        System.out.println(new Solution().solution(a1, b1));
        System.out.println(new Solution().solution(a2, b2));
        System.out.println(new Solution().solution(a3, b3));
    }
}

/*

["frodo", "fradi", "crodo", "abc123", "frodoc"]
["*rodo", "*rodo", "******"]

 */