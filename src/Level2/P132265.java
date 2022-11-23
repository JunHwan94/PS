import java.util.*;
class P132265 {
    public int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int k : topping) {
            map2.put(k, map2.computeIfAbsent(k, it -> 0) + 1);
        }

        for(int k : topping){
            map1.put(k, map1.computeIfAbsent(k, it -> 0) + 1);
            if(map2.get(k) != null){
                map2.put(k, map2.get(k) - 1);
                if(map2.get(k) <= 0){
                    map2.remove(k);
                }
            }

            if(map1.size() == map2.size()){
                answer++;
            }
        }
        return answer;
    }
}
