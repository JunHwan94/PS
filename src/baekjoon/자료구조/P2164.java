package baekjoon.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++)
            q.offer(i);

        int cnt = 0;
        while(q.size() > 1){
            if(cnt % 2 == 0) q.poll();
            else q.offer(q.poll());
            cnt++;
        }
        System.out.println(q.poll());
    }
}
