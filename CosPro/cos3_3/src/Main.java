// 다음과 같이 import를 사용할 수 있습니다.

class Solution {
    public int solution(String[] bishops) {
        // 여기에 코드를 작성해주세요.
        int answer = 0;
        int[][] a = new int[8][8];

        for (int k = 0; k < bishops.length; k++) {
            int x = bishops[k].charAt(1) - '1';
            int y = bishops[k].charAt(0) - 'A';

            for (int i = 0; i < 8; i++) {
                int nx = x + i;
                int ny = y + i;
                if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
                    a[nx][ny] = 1;
                }
                nx = x + i;
                ny = y - i;
                if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
                    a[nx][ny] = 1;
                }
                nx = x - i;
                ny = y + i;
                if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
                    a[nx][ny] = 1;
                }
                nx = x - i;
                ny = y - i;
                if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
                    a[nx][ny] = 1;
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (a[i][j] == 0)
                    answer++;
            }
        }

        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] bishops1 = {new String("D5")};
        int ret1 = sol.solution(bishops1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        String[] bishops2 = {new String("D5"), new String("E8"), new String("G2")};
        int ret2 = sol.solution(bishops2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}