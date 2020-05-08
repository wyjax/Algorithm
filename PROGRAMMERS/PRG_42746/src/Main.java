import java.util.Arrays;
import java.util.Comparator;

class Solution {
    String arr[];

    public String solution(int[] numbers) {
        arr = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            arr[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        if (arr[0].equals("0"))
            return "0";

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numbers.length; i++)
            sb.append(arr[i]);

        return sb.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        int num[] = {1,2,3,4};
        System.out.println(new Solution().solution(num));
    }
}