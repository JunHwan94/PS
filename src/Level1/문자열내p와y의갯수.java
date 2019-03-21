package Level1;

public class 문자열내p와y의갯수 {
    boolean solution(String s) {
        s = s.toUpperCase();
        int py = 0;
        for(char c : s.toCharArray())
            py += c == 'P' ? 1 : c == 'Y' ? -1 : 0;
        boolean answer = py == 0 ? true : false;
        return answer;
    }
}
