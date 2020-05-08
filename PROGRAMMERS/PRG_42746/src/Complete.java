import java.util.Arrays;

public class Complete {
    public String solution(int[] numbers) {
        String[] str = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            str[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(str, (o1, o2) -> (o2 + o1).compareTo((o1 + o2)));

        if (str[0].equals("0"))
            return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : str)
            sb.append(s);

        return sb.toString();
    }
}
