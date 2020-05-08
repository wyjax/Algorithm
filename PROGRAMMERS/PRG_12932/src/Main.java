

/*
프로그래머스 : 자연수 뒤집어 배열로 만들기
레벨 1
 */

class Solution {
    public int[] solution(long n) {
        // 숫자를 문자열로 저장
        String str = Long.toString(n);
        // 문자열 길이만큼 int 배열 생성
        int[] answer = new int[str.length()];

        int j = 0;
        // 문자열은 뒤에서부터 시작
        for (int i = str.length() - 1; i >= 0; i--) {
            // 배열은 앞에서부터 저장
            answer[j++] = str.charAt(i) - '0';
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}