package Level1;
import java.util.*;

public class 나누어떨어지는숫자배열 {
    public int[] solution(int[] arr, int divisor) {
        int[] answer;
        List<Integer> answerList = new ArrayList<>();
        for(int i = 0; i < arr.length; i++)
            if(arr[i] % divisor == 0)
                answerList.add(arr[i]);

        Collections.sort(answerList);
        if(answerList.size() != 0) {
            answer = new int[answerList.size()];
            for(int i = 0; i < answerList.size(); i++)
                answer[i] = answerList.get(i);
        } else{
            answer = new int[1];
            answer[0] = -1;
        }

        return answer;
    }
}
