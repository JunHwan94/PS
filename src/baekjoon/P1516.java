package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1516 {

    static class Building implements Comparable<Building>{
        int no, time, inCount;
        List<Integer> nextList = new ArrayList<>();

        Building(int no){
            this.no = no;
        }

        @Override
        public int compareTo(Building o) {
            return inCount == o.inCount ?
                    time - o.time
                    : inCount - o.inCount;
        }
    }

    static int N;
    static Building[] buildings;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());

        buildings = new Building[N + 1];
        for (int i = 1; i < N + 1; i++) {
            buildings[i] = new Building(i);
        }

        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            buildings[i].time = stoi(st.nextToken());
            int in;
            while((in = stoi(st.nextToken())) != -1){
                buildings[i].inCount++; // i번 건물에 필요한 이전 단계 건물 수
                buildings[in].nextList.add(i); // in 건물 지은 다음에 i 지어야함
            }
        }

        Queue<Building> pq = new PriorityQueue<>();
        // 지을 수 있는 건물 넣기
        for (int i = 1; i < N + 1; i++) {
            if(buildings[i].inCount == 0){
                pq.offer(buildings[i]);
            }
        }

        int[] times = new int[N + 1];
        // 필요한 이전 건물 중 늦게끝나는 시간이 건설 시작시간
        while(!pq.isEmpty()){
            Building b = pq.poll();
            // 시작 시간 + 소요 시간
            times[b.no] += b.time;
            for (int i : b.nextList) {
                buildings[i].inCount--;
                // 다음 건물 시작시간 설정
                times[i] = Math.max(times[i], times[b.no]);
                // 다음 건물에 필요한 건물 다지음
                if (buildings[i].inCount == 0) {
                    pq.offer(buildings[i]);
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            System.out.println(times[i]);
        }
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
