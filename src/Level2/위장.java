package Level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 위장 {
    public static int solution(String[][] clothes){
        int answer = 0;
        List<String> kinds = new ArrayList<>();
        Map<String, String> clothMap = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            if(!kinds.contains(clothes[i][1]))
                kinds.add(clothes[i][1]);
            clothMap.put(clothes[i][0], clothes[i][1]);
        }
        System.out.println(clothMap.keySet().toArray()[0]);

        return answer;
    }

    public static void main(String[] args){
        String[][] s = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        solution(s);
    }
}
