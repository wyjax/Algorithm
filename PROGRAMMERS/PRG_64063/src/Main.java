import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public long[] solution(long k, long[] room_number) {
        HashMap<Long, Long> rooms = new HashMap<>();
        long[] answer = new long[room_number.length];
        int index = 0;

        for (long wantRoom : room_number) {
            // 이미 누가 방에 있다면
            if (rooms.containsKey(wantRoom)) {
                ArrayList<Long> tmp = new ArrayList<>();

                while (rooms.containsKey(wantRoom)) {
                    wantRoom = rooms.get(wantRoom);
                    tmp.add(wantRoom);
                }
                for (long idx : tmp) {
                    rooms.put(idx, wantRoom + 1);
                }
            }
            rooms.put(wantRoom, wantRoom + 1);
            answer[index] = wantRoom;
            index++;
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        long[] a = {1, 3, 4, 1, 3, 1};
        new Solution().solution(10, a);
    }
}
