package Level1;

import java.util.*;
public class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(completion);
        Arrays.sort(participant);

        Map<Integer, String> cMap = new HashMap<>();
        for(int i = 0; i < completion.length; i++){
            cMap.put(i, completion[i]);
        }
        for(int i = 0; i < participant.length; i++){
            if(!participant[i].equals(cMap.get(i))) {
                answer = participant[i];
                break;
            }
        }
        return answer;
    }
}
