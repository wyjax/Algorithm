class Solution {
    public String getHint(String secret, String guess) {
        int[] a = new int[10];
        int A = 0;
        int B = 0;

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                A++;
            }
            else {
                a[secret.charAt(i) - '0']++;
            }
        }

        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                continue;
            }

            if (a[guess.charAt(i) - '0'] > 0) {
                B++;
                a[guess.charAt(i) - '0']--;
            }
        }

        return (A + "A" + B + "B");
    }

    public String getHint2(String secret, String guess) {
        int[] a = new int[10];
        int A = 0;
        int B = 0;

        for (int i = 0; i < secret.length(); i++) {
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);

            if (c1 == c2) {
                A++;
            }
            else {
                if (a[c1 - '0'] < 0) {
                    a[c1 - '0']++;
                    B++;
                }
                if (a[c2 - '0'] > 0) {
                    a[c2 - '0']--;
                    B++;
                }
            }
        }

        return (A + "A" + B + "B");
    }
}

public class Main {
    public static void main(String[] args) {

    }
}