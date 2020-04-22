package sort;

public class SelectionSort implements Sort {

    @Override
    public void sort(int[] arr) {
        System.out.println("========Bubble Sort========");

        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIdx] > arr[j]) {
                    minIdx = j;
                }
            }

            int swap = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = swap;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("===========================");
    }
}
