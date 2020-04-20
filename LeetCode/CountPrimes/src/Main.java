
class Solution {
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n];
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (!prime[i]) {
                count++;
                for (int j = i + i; j < n; j += i) {
                    prime[j] = true;
                }
            }
        }

        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().countPrimes(3));
    }
}
