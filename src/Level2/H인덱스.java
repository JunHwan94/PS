package Level2;

import java.util.*;
import java.util.stream.Collectors;

public class H인덱스 {
    public int solution(int[] citations) {
        int answer = 0;
        List<Integer> cList = Arrays.stream(citations).boxed().sorted().collect(Collectors.toList());
        Collections.reverse(cList);
        System.out.println(cList.toString());
        if(cList.get(cList.size() - 1) >= citations.length)
            return citations.length;
        for(int i = 0; i < cList.size(); i++)
            if(cList.get(i) <= i)
                return i;

        return answer;
    }
}
