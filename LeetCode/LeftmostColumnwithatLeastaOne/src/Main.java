import java.util.List;

/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 */
interface BinaryMatrix {
    public int get(int x, int y);

    public List<Integer> dimensions();
};

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> list = binaryMatrix.dimensions();
        int n = list.get(0);
        int m = list.get(1);

        if (n == 0 || m == 0)
            return -1;

        int result = -1;
        int r = 0;
        int c = m - 1;

        while (r < n && c >= 0) {
            if (binaryMatrix.get(r, c) == 1) {
                result = c;
                c--;
            }
            else {
                r++;
            }
        }
        return result;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
