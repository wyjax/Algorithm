import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        // 정렬해주고 큰거 + 작은거 조합으로 나갈 수 있도록 한다.
        // 이렇게 정렬해서 제일 큰거와 제일 작은 것이 된다면 그 다음 큰거는 무조건 맞기
        // 때문에 제일 큰거로 비교한다.
        Arrays.sort(people);

        int idx = 0;
        for(int i = people.length - 1; i >= idx; i--) {
            if (people[i] + people[idx] <= limit)
                idx++;

            answer++;
        }

        return answer;
    }
}

/*
    아래와 같이 for문 2개로 풀면 "timeout" 발생
    조건이 50000명이어서 검사하려고 for문 2개를 쓴다면 50000^2이 발생하는데 십업이 넘어감

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);


        for(int i = people.length - 1; i >= 0; i--) {
            if (people[i] < 0)
                continue;

            for(int j = i - 1; j >= 0; j--) {
                if (people[j] < 0)
                    continue;
                else if (people[i] + people[j] <= limit) {
                    people[j] = -1;
                    break;
                }
            }
            people[i] = -1;

            answer++;
        }

        return answer;
    }
}
*/
public class Main {
    public static void main(String[] args) {

    }
}
