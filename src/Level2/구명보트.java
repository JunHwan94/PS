package Level2;

import java.util.*;
import java.util.stream.*;
public class 구명보트 {
    public static int solution(int[] people, int limit) {
        int answer = 0;
        List<Integer> pList =
                Arrays.stream(people)
                        .boxed()
                        .collect(Collectors.toList());
        Collections.sort(pList);
        Collections.reverse(pList);
        List<Integer> iList;
        int sum;
        while(pList.size() != 0){
            iList = new ArrayList<>();
            sum = 0;
            for(int i = 0; i < pList.size(); i++){
                if(iList.size() < 2) {
                    if (pList.contains(limit - sum)) {
                        iList.add(i);
                        break;
                    } else if (sum + pList.get(i) < limit) {
                        sum += pList.get(i);
                        iList.add(i);
                    }
                }
            }
            Collections.reverse(iList);
            for(int i : iList){
                pList.remove(i);
            }
            answer++;
        }
        return answer;
    }
}
