import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        new Solution().isHappy(2);
    }
}

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);

        while (n != 1) {
            int val = cal(n);
            if (set.contains(val))
                return false;
            set.add(n);
            n = val;
        }
        return true;
    }

    public int cal(int n) {
        int ans = 0;

        while (n > 0) {
            int a = n % 10;
            ans += (a * a);
            n /= 10;
        }
        return ans;
    }
}
