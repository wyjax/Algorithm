// 다음과 같이 import를 사용할 수 있습니다.

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    final int[] dx = {1, -1, 0, 0};
    final int[] dy = {0, 0, 1, -1};

    public int solution(int n, int[][] garden) {
        // 여기에 코드를 작성해주세요.
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                if (garden[i][j] == 1) {
                    q.add(i);
                    q.add(j);
                }
        }

        while (q.size() > 0) {
            int x = q.remove();
            int y = q.remove();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (garden[nx][ny] > 0) continue;
                garden[nx][ny] = garden[x][y] + 1;
                q.add(nx);
                q.add(ny);
                answer = garden[nx][ny] - 1;
            }
        }

        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution sol = new Solution();
        int n1 = 3;
        int[][] garden1 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int ret1 = sol.solution(n1, garden1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int n2 = 2;
        int[][] garden2 = {{1, 1}, {1, 1}};
        int ret2 = sol.solution(n2, garden2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");

    }
}