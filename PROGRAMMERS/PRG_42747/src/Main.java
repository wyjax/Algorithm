import java.util.Arrays;

class Solution {
    int cnt[] = new int[10001];

    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        // h개가 h번이상 인용되고 나머지가 h이하 인용되어야함
        int h = 0;
        int k = 0;

        for(int i = 0; i < citations.length; i++) {
            if((citations.length - i) <= citations[i]) {
                return citations.length - i;
            }
        }

        return 0;
    }
}

public class Main {
    public static void main(String []args) {
        int n[] = {3, 0, 6, 1, 5};
        // 5편의 논문중 3번이상 인용된 논문이 3편이고 나머지는 3번이하 인용되었다
        System.out.println(new Solution().solution(n));
    }
}