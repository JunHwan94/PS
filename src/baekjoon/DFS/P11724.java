package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P11724 {
    static int n;
    static int m;
    static boolean[] visited;
    static boolean[][] connected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        visited = new boolean[n + 1];
        connected = new boolean[n + 1][n + 1];
        for(int i = 0; i < m; i++){
            token = new StringTokenizer(br.readLine());
            int pivot = Integer.parseInt(token.nextToken());
            int next = Integer.parseInt(token.nextToken());
            connected[pivot][next] = true;
            connected[next][pivot] = true;
        }

        // 각 요소 차례로 탐색
        for(int i = 1; i <= n; i++){
            if(!visited[i]) { // 이미 방문했으면 탐색안함
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);
        br.close();
    }

    static int cnt;
    /**
     * @param k 탐색값
     */
    static void dfs(int k){
        visited[k] = true;
        for(int i = 0; i < connected[k].length; i++){
            if(connected[k][i] && !visited[i]) // k와 i가 연결돼있고 i에 방문하지 않았으면
                dfs(i); // i로 dfs
        }
    }
}
