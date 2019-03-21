package Level1;

public class 문자열다루기기본 {
    public boolean solution(String s) {
        boolean answer = true;
        if(s.length() == 4 || s.length() == 6){
            for(char c : s.toCharArray())
                if(57 < c || c < 47) return false;
        } else return false;
        return answer;
    }
}
