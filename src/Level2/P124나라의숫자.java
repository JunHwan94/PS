package Level2;

public class P124나라의숫자 {
    public String solution(int n) {
        String answer = "";
        answer += check(n);
        return answer;
    }
    public String check(int n){
        String s = "";
        int q = n / 3;
        int r = n % 3;
        if(r == 0) {
            q--;
            r = 4;
        }
        if(3 < q) s += check(q) + r;
        else {
            if(q != 3)
                s += q != 0 ? q + "" + r : r;
            else
                s += ++q + "" + r;
        }
        return s;
    }
}
