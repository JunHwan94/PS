package Level1;
import java.util.*;
import java.util.stream.Collectors;

public class 제일작은수제거하기 {
    public int[] solution(int[] arr) {
        int[] answer = arr.length == 1 ? new int[arr.length] : new int[arr.length - 1];
        if(arr.length == 1)
            answer[0] = -1;
        else{
            List<Integer> iList = Arrays.stream(arr)
                    .boxed()
                    .collect(Collectors.toList());
            iList.remove(Collections.min(iList));
            for(int i = 0; i < iList.size(); i++)
                answer[i] = iList.get(i);
        }
        return answer;
    }
}
