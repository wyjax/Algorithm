
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        int mid = 1;

        while (left <= right) {
            mid = left + (right - left) / 2;
            int val = guess(mid);

            if (val == -1) {
                right = mid - 1;
            }
            else if (val == 1) {
                left = mid + 1;
            }
            else {
                break;
            }
        }
        return mid;
    }

    public int guess(int num) {
        return 0;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
