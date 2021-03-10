/*
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
 */

class Solution {
    public String intToRoman(int num) {
        int[] key = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] values = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < key.length; i++) {
            while (num >= key[i]) {
                sb.append(values[i]);
                num -= key[i];
            }
        }

        return sb.toString();
    }
}
