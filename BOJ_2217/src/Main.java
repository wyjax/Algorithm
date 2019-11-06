import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        int arr[] = new int[tc];

        /*
            인덱스 0부터 tc까지 값 중에서 최대로 버틸수 있는 무게 중 최대값을 구하면 된다.ㅇ
         */

        for(int i = 0; i < tc; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int max = 0;
        for(int i = 0; i < tc; i++) {
            int val = (tc - i) * arr[i];

            if (max < val)
                max = val;
        }


        System.out.println(max);
    }
}