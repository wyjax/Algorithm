import java.rmi.dgc.Lease;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int totalTicket = 2000;
        String logs[] = {
                "woni request 09:12:29",
                "brown request 09:23:11",
                "brown leave 09:23:44",
                "jason request 09:33:51",
                "jun request 09:33:56",
                "cu request 09:34:02"
        };
        new Solution().solution(totalTicket, logs);
    }
}

class Solution {
    HashSet<String> set = new HashSet<>();

    public void solution(int ticket, String[] logs) {
        boolean isvisit = false;
        int cnt = 0;
        String curid = "";
        String endtime = "";

        for (int i = 0; i < logs.length; i++) {
            if (cnt >= ticket)
                break;
            String s[] = logs[i].split(" ");

            if (isvisit) {
                // 이미 쓰고있는데 떠날 때
                if (s[0].equals(curid) && s[1].equals("leave")) {
                    isvisit = false;
                    if (endtime.compareTo(s[2]) < 0 && !set.contains(curid)) {
                        set.add(curid);
                        cnt++;
                    }
                }
                else if (endtime.compareTo(s[2]) <= 0) {
                    if (!set.contains(curid)) {
                        set.add(curid);
                        cnt++;
                    }
                    curid = s[0];
                    endtime = getTime(s[2]);
                    if (endtime.compareTo("10:00:00") >= 0) break;
                }
            }
            else {
                if (s[1].equals("request")) {
                    curid = s[0];
                    endtime = getTime(s[2]);
                    isvisit = true;
                    if (endtime.compareTo("10:00:00") >= 0) break;
                }
            }
        }
        if (isvisit && endtime.compareTo("10:00:00") <= 0 && cnt < ticket) {
            set.add(curid);
        }
        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list);
    }

    public String getTime(String time) {
        String m = time.substring(3, 5);
        String s = time.substring(6, 8);
        int a = m.charAt(0) - '0';
        int b = m.charAt(1) - '0';

        b++;
        if (b > 9) {
            b = 0;
            a++;
            if (a > 5 && !s.equals("00"))
                return "10:00:01";
        }

        String rtnTime = time.substring(0, 2) + ":" + Integer.toString(a) + Integer.toString(b) + time.substring(5, time.length());
        return rtnTime;
    }
}