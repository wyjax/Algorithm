
class Solution {
    public int getSum(int a, int b) {
        return a + b;
    }

    public int getSum2(int a, int b) {
        while (b != 0) {
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        /*
            1010 > 10
            0111 > 7

            XOR 1101
            AND 0100

            1001
            1000
         */

        return a;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
