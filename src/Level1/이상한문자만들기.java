package Level1;

public class 이상한문자만들기 {
    public String solution(String s) {
        String answer="";
        StringBuilder sb = new StringBuilder();

        int j = 1;
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                sb.append(j % 2 != 0 ? Character.toUpperCase(s.charAt(i)) : Character.toLowerCase(s.charAt(i)));
                j++;
            }
            else {
                sb.append(s.charAt(i));
                j = 1;
            }
        }

        answer = sb.toString();
        return answer;
    }
}
