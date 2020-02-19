class Solution {
    public int solution(int[][] baseball) {
        int answer = 0;

        for (int i = 123; i <= 987; i++) {
            String s = Integer.toString(i);
            boolean check = true;
            if (s.charAt(0) == s.charAt(1) || s.charAt(0) == s.charAt(2) || s.charAt(1) == s.charAt(2)) continue;
            if (s.charAt(0) == '0' || s.charAt(1) == '0' || s.charAt(2) == '0') continue;

            for (int j = 0; j < baseball.length; j++) {
                int strike = 0;
                int ball = 0;

                for (int k = 0; k < 3; k++) {
                    String s2 = Integer.toString(baseball[j][0]);
                    for (int t = 0; t < 3; t++) {
                        if (k == t && s.charAt(k) == s2.charAt(t)) {
                            strike++;
                            continue;
                        }
                        else if (s.charAt(k) == s2.charAt(t)) {
                            ball++;
                            continue;
                        }
                    }
                }
                if (strike != baseball[j][1] || ball != baseball[j][2]) {
                    check = false;
                    break;
                }
            }
            if (check)
                answer++;
        }

        return answer;
    }
}