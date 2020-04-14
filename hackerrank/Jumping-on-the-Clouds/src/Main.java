

class Solution {
    // Complete the jumpingOnClouds function below.
    int jumpingOnClouds(int[] c) {
        int answer = 0;
        int i = 0;

        while (i < c.length) {
            if (i + 2 < c.length && c[i + 2] == 0) {
                answer++;
                i += 2;
            }
            else if (i + 1 < c.length && c[i + 1] == 0){
                answer++;
                i++;
            }
            else {
                break;
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] a = {0, 0, 0, 0, 1, 0};
        System.out.println(new Solution().jumpingOnClouds(a));
    }
}
