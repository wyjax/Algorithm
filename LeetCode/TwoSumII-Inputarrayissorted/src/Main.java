import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i + 1);
        }

        for (int i = 0; i < numbers.length; i++) {
            int sum = target - numbers[i];

            if (map.containsKey(sum)) {
                int index1 = map.get(sum);

                if (index1 == i + 1) {
                    continue;
                }

                int index2 = i + 1;
                int[] a = {(index1 < index2 ? index1 : index2), (index1 > index2 ? index1 : index2)};
                return a;
            }
        }
        return new int[2];
    }
}