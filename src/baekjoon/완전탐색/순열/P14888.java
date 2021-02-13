package baekjoon.완전탐색.순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14888 {
    static int N;
    static Queue<Integer> inQueue = new LinkedList<>();
    static boolean[] visited;
    static int max = -1000000000;
    static int min = 1000000000;
    static StringBuilder sb = new StringBuilder();
    static char[] oArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        visited = new boolean[N + 1];
        oArr = new char[N - 1];
        for(int n = 0; n < N; n++)
            inQueue.offer(Integer.parseInt(token.nextToken()));
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            int oCnt = Integer.parseInt(token.nextToken());
            for(int j = 0; j < oCnt; j++){
                char c = '\u0000';
                switch(i){
                    case 0: c = '+'; break;
                    case 1: c = '-'; break;
                    case 2: c = '*'; break;
                    case 3: c = '/'; break;
                }
                sb.append(c);
            }
        }

        perm(0);
        System.out.println(max);
        System.out.println(min);
    }

    static void perm(int cnt){
        if(cnt == N - 1){
            Queue<Integer> tq = new LinkedList<>(inQueue);
            int acc = tq.poll();
            for(int i = 0; i < N - 1; i++){
                char c = oArr[i];
                switch(c){
                    case '+': acc += tq.poll(); break;
                    case '-': acc -= tq.poll(); break;
                    case '*': acc *= tq.poll(); break;
                    case '/': acc /= tq.poll(); break;
                }
            }
            if(acc < min) min = acc;
            if(acc > max) max = acc;
            return;
        }

        for(int i = 0; i < N - 1; i++){
            if(visited[i]) continue;
            visited[i] = true;
            oArr[cnt] = sb.charAt(i);
            perm(cnt + 1);
            visited[i] = false;
        }
    }
}
