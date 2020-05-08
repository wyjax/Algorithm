import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 뒤 - 앞 하면 내림차순으로 정렬된당.
                return o2[0] - o1[0];
            }
        });
        /*
        시작지점을 큰 순서대로 저장한 다음 tmp에 제일 큰 수를 지정하고
        [i][1] < tmp이면 tmp = [i][0]한다.
            >> [i][0]을 저장하면 tmp는 [i][0]로 정렬되어 있어 다음에 올 [i][0]보다 무조건 크다
               그러기 때문에 [i][1]만 비교해준다.
        [i][1] < tmp 이면 카메라 개수를 1개 늘린다.
         */

        int tmp = 30000;
        for (int i = 0; i < routes.length; i++) {
            if (tmp > routes[i][1]) {
                tmp = routes[i][0];
                answer++;

            }
        }
        return answer;
    }
    /*
       -20                            15
           -18   -13
               -14       -5
                         -5   -3
                                             ... 30000
     */
}

public class Main {
    public static void main(String[] args) {
        int arr[][] = {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}};
        System.out.println(new Solution().solution(arr));
    }
}
