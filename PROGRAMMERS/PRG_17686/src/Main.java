import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        String[][] a = new String[files.length][3];

        for (int i = 0; i < files.length; i++) {
            String[] b = separate(files[i]);
            a[i] = b;
        }

        Arrays.sort(a, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                int com = o1[0].toLowerCase().compareTo(o2[0].toLowerCase());

                if (com == 0) {
                    int first = Integer.parseInt(o1[1]);
                    int second = Integer.parseInt(o2[1]);
                    com = first - second;
                }
                return com;
            }
        });

        for (int i = 0; i < files.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (String tmp : a[i])
                sb.append(tmp);
            answer[i] = sb.toString();
        }

        return answer;
    }

    public String[] separate(String s) {
        String[] ans = new String[3];
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int i = 0;

        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                ans[idx++] = sb.toString();
                break;
            }
            sb.append(c);
        }

        sb = new StringBuilder();
        int cnt = 0;
        for (; i < s.length() && cnt < 5; i++, cnt++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9')
                sb.append(c);
            else
                break;
        }
        ans[idx++] = sb.toString();
        ans[idx] = s.substring(i, s.length());

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        String[] a = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] b = {"img99999.png", "img000003.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        new Solution().solution(b);
    }
}
