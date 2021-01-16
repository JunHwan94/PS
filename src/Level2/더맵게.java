package Level2;

import java.util.PriorityQueue;
import java.util.Queue;

public class 더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i : scoville)
            priorityQueue.offer(i);
        int combined = 0;
        int l;
        int r;
        while(!priorityQueue.isEmpty() && priorityQueue.element() < K){
            l = priorityQueue.remove();
            if(!priorityQueue.isEmpty()) {
                r = priorityQueue.remove();
                if (l < r) combined = l + r * 2;
                else combined = r + l * 2;
                priorityQueue.offer(combined);
                answer++;
            }else if(l < K) return -1;
            else break;
        }
        return answer;
    }
}
