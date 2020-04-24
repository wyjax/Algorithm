
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        System.out.println(m + " " + n);

        while (m < n) {
            m >>= 1;
            n >>= 1;
            shift++;
        }
        return m << shift;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().rangeBitwiseAnd(5, 7235235));
    }
}

class Pair {

}