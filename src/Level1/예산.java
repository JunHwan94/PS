package Level1;
import java.util.Arrays;

public class 예산 {
    public int solution(int[] d, int budget) {
        int answer=0;
        Arrays.sort(d);
        for(int i : d)
            if(0 <= budget - i) {
                budget -= i;
                answer++;
            }
        return answer;
    }
}
