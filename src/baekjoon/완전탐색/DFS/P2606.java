package baekjoon.완전탐색.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2606 {
    static int comCnt;
    static boolean[][] connected;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        comCnt = Integer.parseInt(br.readLine());
        int conCnt = Integer.parseInt(br.readLine());
        visited = new boolean[comCnt + 1];
        connected = new boolean[comCnt + 1][comCnt + 1];

        for(int i = 0; i < conCnt; i++){
            StringTokenizer token = new StringTokenizer(br.readLine());
            int pivot = Integer.parseInt(token.nextToken());
            int next = Integer.parseInt(token.nextToken());
            connected[pivot][next] = true;
            connected[next][pivot] = true;
        }

        dfs(1);

        System.out.println(--cnt);
        br.close();
    }

    static int cnt;

    /**
     * @param k 탐색 값
     */
    static void dfs(int k){
        if(visited[k]) return; // 이미 방문했으면
        visited[k] = true;
        cnt++;

        for(int i = 0; i < connected[k].length; i++){
            if(connected[k][i] && !visited[i]) // k와 i가 연결돼있고 i에 방문하지 않았으면
                dfs(i); // 계속 i로 dfs
        }
    }
}