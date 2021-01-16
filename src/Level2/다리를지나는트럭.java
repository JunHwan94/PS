package Level2;

import java.util.ArrayList;
import java.util.List;

public class 다리를지나는트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        List<Integer> trucksOnBridge = new ArrayList<>(bridge_length);
        for(int i = 0; i < bridge_length; i++){
            trucksOnBridge.add(0);
        }

        int waitIdx = 0;
        int sum = 0;
        List<Integer> finishedTrucks = new ArrayList<>();
        boolean isFinished = false;
        while(!isFinished){
            // 다리에 트럭이 없으면
            if(sum == 0) {
                // 트럭 올라감
                trucksOnBridge.remove(0);
                trucksOnBridge.add(truck_weights[waitIdx]);
                sum += truck_weights[waitIdx];
                waitIdx++;
            }
            // 다리에 트럭이 있으면
            else{
                // 트럭이 다리를 건너면 주차
                int truck = trucksOnBridge.remove(0);
                if (truck != 0){
                    finishedTrucks.add(truck);
                    sum -= truck;
                }

                // 다리에 트럭이 올라갈 수 있으면 올라감
                if(waitIdx < truck_weights.length) {
                    if (sum + truck_weights[waitIdx] <= weight) {
                        trucksOnBridge.add(truck_weights[waitIdx]);
                        sum += truck_weights[waitIdx];
                        waitIdx++;
                    }
                    // 다리에 트럭이 못올라가면 빈공간을 만듬
                    else trucksOnBridge.add(0);
                }
            }

            if(finishedTrucks.size() == truck_weights.length)
                isFinished = true;

            answer++;
        }

        return answer;
    }
}
