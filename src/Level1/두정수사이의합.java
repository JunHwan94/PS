package Level1;

public class 두정수사이의합 {
    public long solution(int a, int b) {
        long answer = 0;
        int i = a < b ? a : b;
        int j = i == a ? b : a;
        while(i <= j){
            answer += i;
            i++;
        }
        return answer;
    }
}
