package test.streami;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class P2 {
    public static void main(String[] args) {
        System.out.println(solution("abccbd", new int[]{0, 1, 2, 3, 4, 5}));
        System.out.println(solution("aabbcc", new int[]{1,2,1,2,1,2}));
    }

    public static int solution(String S, int[] C){
        List<Queue<Integer>> costs = new ArrayList<>();
        char c = S.charAt(0);
        if(c == S.charAt(1)){
            costs.add(new PriorityQueue<>());
            costs.get(0).offer(C[0]);
            costs.get(0).offer(C[1]);
        }
        for (int i = 2; i < S.length(); i++) {
            if(S.charAt(i - 1) == S.charAt(i)){
                if(c == S.charAt(i)){
                    costs.get(costs.size() - 1).add(C[i]);
                }
            }else{
                c = S.charAt(i - 1);
                costs.add(new PriorityQueue<>());
            }
        }

        int sum = 0;
        for (Queue<Integer> q : costs) {
            if(q.isEmpty()){
                continue;
            }
            while(q.size() != 1){
                sum += q.poll();
            }
        }

        return sum;
    }
}
