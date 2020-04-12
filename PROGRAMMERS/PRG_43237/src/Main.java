import java.util.Arrays;

class Solution {
    public int solution(int[] budgets, int M) {
        int len = budgets.length;
        long[] d = new long[len];
        Arrays.sort(budgets);

        d[0] = budgets[0];
        for (int i = 1; i < len; i++)
            d[i] = budgets[i] + d[i - 1];
        int budge = budgets[len - 1];

        while (true) {
            int idx = search(budge, budgets);
            long tmp = (budge * (len - idx)) + (idx > 0 ? d[idx - 1] : 0);

            if (tmp <= M) break;
            budge--;
        }
        return budge;
    }

    public int search(long target, int[] budgets) {
        int left = 0, right = budgets.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (target > budgets[mid])
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] a = {120, 110, 140, 150};
        int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(new Solution().solution(a, 485));
    }
}

/*
    < 다른 사람의 풀이 >

    import java.util.*;

    class Solution
    {
        public int solution(int[] budgets, int M)
        {
            Arrays.sort(budgets);
            int start = 0, end = budgets[budgets.length - 1];
            while(start <= end)
            {
                int sum = 0;
                int mid = (start + end) / 2;
                for(int element : budgets)
                    sum = element > mid ? sum + mid : sum + element;
                if(sum > M) end = mid - 1;
                else
                    start = mid + 1;
            }
            return end;
        }
    }
 */
