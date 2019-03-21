package Level1;
import java.util.*;

public class 같은숫자는싫어 {
    public int[] solution(int []arr) {
    List<Integer> aList = new ArrayList<>();
    for(int i = 0; i < arr.length; i++){
        if(0 < i){
            if (arr[i] != arr[i - 1])
                aList.add(arr[i]);
        }
        else aList.add(arr[i]);
    }

    int[] answer = new int[aList.size()];
    for(int i = 0; i < answer.length; i++)
        answer[i] = aList.get(i);
    return answer;
}
}
