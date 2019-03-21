package Level1;
import java.util.*;
import java.util.stream.Collectors;

public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        List<Integer> reserveList;
        reserveList =
                Arrays.stream(reserve)
                        .boxed()
                        .collect(Collectors.toList());

        for(int idx : lost)
            if(reserveList.contains(idx)) {
                answer++;
                reserveList.remove(reserveList.indexOf(idx));
            }
            else if(reserveList.contains(idx-1)) {
                answer++;
                reserveList.remove(reserveList.indexOf(idx-1));
            }
            else if(reserveList.contains(idx+1)) {
                answer++;
                reserveList.remove(reserveList.indexOf(idx+1));;
            }

        return answer;
    }
}
