package Level1;

public class 시저암호 {
    public String solution(String s, int n) {
        String answer = "";
        for(char c : s.toCharArray()) {
            c += c == 32 ? 0 : n;
            c -= 122 < c ? 26 : 90 < c && c <= 90 + n ? 26 : 0;
            answer += c;
        }
        return answer;
    }
}
