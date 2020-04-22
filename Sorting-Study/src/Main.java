import sort.BubbleSort;
import sort.SelectionSort;

public class Main {
    public static void main(String[] args) {
        int[] tc = {2, 5, 8, 4, 2, 4, 2, 14, 63};

        new BubbleSort().sort(tc);
        new SelectionSort().sort(tc);
    }
}
