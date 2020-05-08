public class mycode {
    public String solution(String sentence) {
        String answer = "";
        int alpha[] = new int[27];
        boolean check[] = new boolean[27];
        int len = sentence.length();

        for (int i = 0; i < sentence.length(); i++) {
            if (Character.isLowerCase(sentence.charAt(i)))
                alpha[sentence.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            char first = sentence.charAt(i);
            if (first == ' ')
                continue;

            if (Character.isUpperCase(first)) {
                if (i + 1 == len) {
                    sb.append(first + " ");
                    break;
                }
                char second = sentence.charAt(i + 1);
                if (Character.isUpperCase(second)) {
                    sb.append(first + " ");
                } // A a
                else if (Character.isLowerCase(second)) {
                    // 이미 사용한 소문자
                    if (check[second - 'a'])
                        return "invalid";
                    sb.append(first);
                    StringBuilder sb_second = new StringBuilder();
                    int j = i + 1;
                    for (; j < len; j++) {
                        if (Character.isUpperCase(sentence.charAt(j - 1)) && Character.isLowerCase(sentence.charAt(j)) && sentence.charAt(j) != second) {
                            j--;
                            break;
                        }
                        /*
                        else if (Character.isLowerCase(sentence.charAt(j)) && sentence.charAt(j) != second) {
                            return "invalid";
                        }
                         */
                        else if (Character.isLowerCase(sentence.charAt(j - 1)) && Character.isLowerCase(sentence.charAt(j)))
                            return "invalid";
                        else if (Character.isUpperCase(sentence.charAt(j)) && Character.isUpperCase(sentence.charAt(j - 1))) {
                            j--;
                            break;
                        }
                        else if (sentence.charAt(j) == second) {
                            if (j + 1 == len)
                                return "invalid";
                            continue;
                        }
                        sb_second.append(sentence.charAt(j));
                    }

                    sb.append(sb_second.toString() + " ");
                    check[second - 'a'] = true;
                    i = j;
                }
            } else if (Character.isLowerCase(first)) {
                if (check[first - 'a'])
                    return "invalid";
                if (alpha[first - 'a'] != 2)
                    return "invalid";
                if (i + 1 == len)
                    return "invalid";

                StringBuilder sb_second = new StringBuilder();

                char two = ' ';
                int cnt = 0;
                int j = i + 1;
                for (; j < len; j++) {
                    // 대문자 일떄
                    if (Character.isUpperCase(sentence.charAt(j))) {
                        sb_second.append(sentence.charAt(j));
                    }
                    // 끝일 때
                    else if (first == sentence.charAt(j)) {
                        break;
                    }
                    else if (Character.isLowerCase(sentence.charAt(j))) {
                        if (check[sentence.charAt(j) - 'a'])
                            return "invalid";
                        else if (two == ' ') {
                            two = sentence.charAt(j);
                            cnt = 1;
                        }
                        else if (two == sentence.charAt(j))
                            cnt++;
                        else if (two != sentence.charAt(j)) {
                            return "invalid";
                        }
                    }
                }
                check[first - 'a'] = true;
                if (two != ' ') {
                    check[two - 'a'] = true;

                    if (sb_second.length() - 1 != cnt)
                        return "invalid";
                }

                sb.append(sb_second.toString() + " ");
                i = j;
            }
        }
        return sb.toString().trim();
    }
}
