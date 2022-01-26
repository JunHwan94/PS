package baekjoon.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class P1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            int input = Integer.parseInt(br.readLine());
            if(input == 0) {
                if (pq.isEmpty()) sb.append("0\n");
                else sb.append(pq.poll()).append("\n");
            }else pq.offer(input);
        }
        System.out.println(sb);
    }
}