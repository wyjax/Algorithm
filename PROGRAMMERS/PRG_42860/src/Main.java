public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("JAZ"));
    }
}

class Solution {
    char[] a;
    int left, right;

    public int solution(String name) {
        int answer = 0, idx = 0;
        a = name.toCharArray();

        while (!check(a)) {
            answer += Math.min('Z' - name.charAt(idx) + 1, name.charAt(idx) - 'A');
            a[idx] = 'A';
            int next = search(idx);
            answer += Math.min(left, right);
            idx = next;
        }

        return answer;
    }

    public int search(int idx) {
        int i = idx + 1, j = idx - 1;
        left = right = 1;

        while (i != idx && right < a.length) {
            if (i >= a.length)
                i = 0;
            if (a[i] != 'A')
                break;
            right++;
            i++;
        }
        while (j != idx && left < a.length) {
            if (j < 0)
                j = a.length - 1;
            if (a[j] != 'A')
                break;
            left++;
            j--;
        }
        if (left == a.length || right == a.length) {
            left = right = 0;
        }

        if (right > left)
            return j;
        return i;
    }

    public boolean check(char[] c) {
        for (int i = 0; i < c.length; i++) {
            if (c[i] != 'A')
                return false;
        }
        return true;
    }
}