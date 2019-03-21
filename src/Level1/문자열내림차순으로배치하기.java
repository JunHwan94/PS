package Level1;
import java.util.*;

public class 문자열내림차순으로배치하기 {
    public String solution(String s) {
        String answer = "";
        List<Character> cl = new ArrayList<>();
        for(char c : s.toCharArray())
            cl.add(c);
        Collections.sort(cl);
        Collections.reverse(cl);
        for(char c : cl)
            answer += c;
        return answer;
    }
}
