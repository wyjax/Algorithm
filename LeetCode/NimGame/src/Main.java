
class Solution {
    public boolean canWinNim(int n) {
        /*
            1 > 승
            2 > 승
            3 > 승
            4 > 패
            5 > 승
            6 > 승
            7 > 승
            8 > 3 4 5
         */
        return (n % 4 != 0);
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
