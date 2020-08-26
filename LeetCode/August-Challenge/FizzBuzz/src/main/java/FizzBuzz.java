import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String ret = numberToString(i);
            answer.add(ret);
        }

        return answer;
    }

    public String numberToString(int num) {
        if (num % 3 == 0 && num % 5 == 0) {
            return "FizzBuzz";
        }
        else if (num % 3 == 0) {
            return "Fizz";
        }
        else if (num % 5 == 0) {
            return "Buzz";
        }

        return String.valueOf(num);
    }
}

public class FizzBuzz {
    public static void main(String[] args) {

    }
}
