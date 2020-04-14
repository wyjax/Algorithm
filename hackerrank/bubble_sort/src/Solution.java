public class Solution {

    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {
        int answer = 0;
        int n = a.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    answer++;
                }
            }
        }
        System.out.println("Array is sorted in " + answer + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length - 1]);
    }
}
