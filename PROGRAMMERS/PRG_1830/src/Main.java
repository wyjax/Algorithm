
class Solution {
    public String solution(String sentence) {
        String answer = "";
        int[] alpha = new int[26];
        boolean[] chk = new boolean[26];
        for (int i = 0; i < sentence.length(); i++) {
            if (Character.isLowerCase(sentence.charAt(i))) {   //각 소문자들의 갯수.
                alpha[sentence.charAt(i) - 'a']++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {
            if (Character.isUpperCase(sentence.charAt(i))) {   //대문자로 시작하는 경우
                if (i + 1 < sentence.length()) {
                    if (Character.isUpperCase(sentence.charAt(i + 1))) {   //다음 문자가 대문자라면
                        sb.append(sentence.charAt(i));    //현재 문자를 넣고 다음으로 넘어간다.
                    } else {   //다음 문자가 소문자라면
                        if (alpha[sentence.charAt(i + 1) - 'a'] == 2) {    //다음 소문자가 2개라면 한 단어를 이룬다.
                            sb.append(sentence.charAt(i)).append(" ");    //현재까지 단어와 분리하고 다음으로 넘어간다.
                        } else {   //다음 소문자가 2개가 아니라면 현재 대문자부터 시작하여 소문자가 끝나는 곳까지 한 단어이다.
                            if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') {
                                sb.append(" ");
                            }
                            int num = alpha[sentence.charAt(i + 1) - 'a'];    //해당 소문자 갯수
                            int start = i;
                            if (chk[sentence.charAt(i + 1) - 'a'] || start + num * 2 >= sentence.length()) {   //이미 사용된 소문자거나 범위를 넘어서면 invalid
                                sb = new StringBuilder().append("invalid");
                                break;
                            }
                            boolean isWord = true;    //단어가 맞는지 체크
                            for (int j = start; j < start + num * 2; j += 2) { //현재 i부터 i += 2를 i + num * 2까지 하며 i가 대문자고 i + 1이 해당 소문자인지 체크
                                if (Character.isUpperCase(sentence.charAt(j)) && sentence.charAt(j + 1) == sentence.charAt(i + 1)) {
                                    sb.append(sentence.charAt(j));
                                } else {   //아니라면 단어가 아니다.
                                    isWord = false;
                                    break;
                                }
                            }
                            if (!isWord) { //단어가 아니면 invalid
                                sb = new StringBuilder().append("invalid");
                                break;
                            } else {   //단어라면 마지막 대문자 넣어주고 마지막 대문자 위치로 i를 점프
                                sb.append(sentence.charAt(start + num * 2));
                                sb.append(" ");
                                chk[sentence.charAt(i + 1) - 'a'] = true;
                                i = start + num * 2;
                            }
                        }
                    }
                } else {
                    sb.append(sentence.charAt(i));
                }
            } else if (Character.isLowerCase(sentence.charAt(i))) {  //소문자로 시작하는 경우
                if (!chk[sentence.charAt(i) - 'a'] && alpha[sentence.charAt(i) - 'a'] == 2) {  //해당 소문자가 사용되지 않았고 2개라면 한 단어를 이룬다.
                    if (Character.isLowerCase(sentence.charAt(i + 1))) {   //다음 문자도 소문자면 규칙에 맞지 않다. invalid
                        sb = new StringBuilder().append("invalid");
                        break;
                    } else {
                        int index = i + 1, lower = 0, upper = 0;  //2개 소문자 사이의 다른 소문자 갯수, 대문자 갯수
                        char low = ' ';
                        boolean isWord = true;
                        while (index < sentence.length() && sentence.charAt(index) != sentence.charAt(i)) {
                            if (Character.isUpperCase(sentence.charAt(index))) {
                                upper++;
                            } else {
                                if (low == ' ') {  //소문자를 얻는다
                                    low = sentence.charAt(index);
                                } else if (low != sentence.charAt(index)) { //소문자가 여러개라면 단어가 아니다.
                                    isWord = false;
                                    break;
                                }
                                lower++;
                            }
                            index++;
                        }
                        if (lower == 0) {  //대문자만 있는 경우
                            for (int j = i + 1; j < index; j++) {
                                sb.append(sentence.charAt(j));
                            }
                            i = index;
                        } else {   //규칙1이 적용된 경우
                            if (isWord && lower + 1 == upper) {
                                if (!chk[low - 'a']) {
                                    for (int j = i + 1; j < index - 1; j += 2) {
                                        if (Character.isUpperCase(sentence.charAt(j)) && sentence.charAt(j + 1) == low) {
                                            sb.append(sentence.charAt(j));
                                        } else {   //아니라면 단어가 아니다.
                                            isWord = false;
                                            break;
                                        }
                                    }
                                } else {
                                    isWord = false;
                                }
                                if (!isWord) { //단어가 아니면 invalid
                                    sb = new StringBuilder().append("invalid");
                                    break;
                                } else {   //단어라면 마지막 대문자 넣어주고 마지막 대문자 위치로 i를 점프
                                    sb.append(sentence.charAt(index - 1));
                                    chk[low - 'a'] = true;
                                    i = index;
                                }
                            } else {
                                sb = new StringBuilder().append("invalid");
                                break;
                            }
                        }
                        sb.append(" ");
                    }
                } else {   //해당 소문자가 이미 사용됐거나 2개가 아니라면 invalid
                    sb = new StringBuilder().append("invalid");
                    break;
                }
            } else {
                sb = new StringBuilder().append("invalid");
                break;
            }
        }

        return answer = sb.toString().trim();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("HaEaLaLObWORLDb"));
    }
}