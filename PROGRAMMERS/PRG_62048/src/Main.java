import java.util.Scanner;

class Solution {
    public long solution(long w, long h) {
        long answer = w * h;

        long gcd = gcd(w, h);
        answer -= gcd * ((w / gcd) + (h / gcd) - 1);

        return answer;
    }

    public long gcd(long w, long h) {
        while (h != 0) {
            long tmp = w % h;
            w = h;
            h = tmp;
        }

        return w;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();

        System.out.println(new Solution().solution(w, h));
    }
}