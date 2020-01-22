import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String s;
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        int sums = 0;
        /*
            괄호의 개수가 처음에 1개인줄 알고 어떻게 풀어야하나 고민을 많이 했다.
            도저히 모르곘어서 구글링해서 정답소스를 보려는데 해설로 여러 번 쓸수 있다는 것을
            안 후 풀었다.

            해결 : +가 나오면 계속 더해주고 -가 나와주면 다시 -가 나올때까지 더한 값을
            sum에 빼주면 된다.
         */

        String tmp = "";
        int i;

        for(i = 0; i < s.length(); i++) {
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9')
                tmp += s.charAt(i);
            else {
                if (tmp.length() > 0) {
                    sums += Integer.parseInt(tmp);
                    tmp = "";
                }
            }

            if (s.charAt(i) == '-') {
                int sub = 0;
                int j;
                for(j = i + 1; j < s.length(); j++) {
                    if ('0' <= s.charAt(j) && s.charAt(j) <= '9')
                        tmp += s.charAt(j);
                    else if (s.charAt(j) == '+') {
                        sub += Integer.parseInt(tmp);
                        tmp = "";
                    }
                    else if (s.charAt(j) == '-') {
                        break;
                    }
                }

                if (tmp.length() > 0)
                    sub += Integer.parseInt(tmp);
                sums -= sub;
                tmp = "";
                i = j - 1;
            }
            else if (s.charAt(i) == '+') {
                int j;
                for(j = i + 1; j < s.length(); j++) {
                    if ('0' <= s.charAt(j) && s.charAt(j) <= '9')
                        tmp += s.charAt(j);
                    else if (s.charAt(j) == '-') {
                        break;
                    }
                    else if (s.charAt(j) == '+') {
                        sums += Integer.parseInt(tmp);
                        tmp = "";
                    }
                }

                if (tmp.length() > 0)
                    sums += Integer.parseInt(tmp);
                tmp = "";
                i = j - 1;
            }
        }
        if (tmp.length() > 0)
            sums += Integer.parseInt(tmp);

        System.out.println(sums);
    }
}