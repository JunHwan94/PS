package baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2110 {

    static int N, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        C = stoi(st.nextToken());

        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.offer(stoi(br.readLine()));
        }

        int left = 0;
        int right = 1000000000;
        int max = 0;
        while(left != right){
            int mid = (left + right) / 2; // 예상 거리
            Queue<Integer> cpq = new PriorityQueue<>(pq);
            int prev = cpq.poll();
            int cnt = 1;
            while(!cpq.isEmpty()){
                int next = cpq.poll();
                if(next - prev >= mid) { // 다음 설치 가능
                    cnt++;
                    prev = next;
                }
            }
            if(cnt >= C){
                left = mid + 1;
                max = Math.max(max, mid);
            }else{
                right = mid;
            }
        }
        System.out.println(max);
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
