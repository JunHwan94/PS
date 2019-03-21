package Level1;
import java.util.*;

public class 문자열내마음대로정렬하기 {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        List<Character> cList = new ArrayList<>();
        List<String> sList = new ArrayList<>();

        for(int i = 0; i < strings.length; i++){
            if(!cList.contains(strings[i].charAt(n)))
                cList.add(strings[i].charAt(n));
        }
        Collections.sort(cList);

        List<String> tList;
        for(int i = 0; i < cList.size(); i++){
            tList = new ArrayList<>();
            for(int j = 0; j < strings.length; j++) {
                if(cList.get(i) == strings[j].charAt(n)){
                    tList.add(strings[j]);
                }
            }
            Collections.sort(tList);
            sList.addAll(tList);
        }

        for(int i = 0; i < sList.size(); i++)
            answer[i] = sList.get(i);
        return answer;
    }
}
