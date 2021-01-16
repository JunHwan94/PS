package Level2;
import java.util.*;

public class 쇠막대기 { // 틀림
    public static int solution(String arrangement) {
        int answer = 0;
        Stack stack = new Stack();
        for(int i = 0; i < arrangement.length(); i++){
            if(arrangement.charAt(i) == '(') {
                stack.push(arrangement.charAt(i));
            } else if(arrangement.charAt(i-1) == ')' && arrangement.charAt(i) == ')'){
                stack.pop();
                answer += 1;
            } else {
                stack.pop();
                answer += stack.size();
            }
        }
        return answer;
    }
}
