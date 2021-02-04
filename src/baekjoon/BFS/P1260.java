package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class P1260 {
    static int n;
    static int m;
    static int start;
    static boolean[] visited;
    static boolean[][] connected;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer token = new StringTokenizer(br.readLine());
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        start = Integer.parseInt(token.nextToken());
        arr = new int[n];
        visited = new boolean[n + 1];
        connected = new boolean[n + 1][n + 1];
        for(int i = 0; i < m; i++){
            token = new StringTokenizer(br.readLine());
            int pivot = Integer.parseInt(token.nextToken());
            int next = Integer.parseInt(token.nextToken());
            connected[pivot][next] = true;
            connected[next][pivot] = true;
        }

        dfs(start);
        Arrays.stream(arr).filter(it -> it != 0).forEach(it -> sb.append(it).append(" "));
        sb.append('\n');
        visited = new boolean[n + 1];
        cnt = 0;
        bfs(start);
        Arrays.stream(arr).filter(it -> it != 0).forEach(it -> sb.append(it).append(" "));
        System.out.println(sb);
    }

    static int cnt;
    static void dfs(int k){
        visited[k] = true;
        arr[cnt++] = k;
        for(int i = 1; i <= n; i++){
            if(!visited[i] && connected[k][i])
                dfs(i);
        }
    }

    static void bfs(int k){
        // 방문표시
        visited[k] = true;
        // 처음항목 큐에 넣기
        Queue<Integer> q = new LinkedList<>();
        q.offer(k);
        arr[cnt++] = k;

        // 큐 빌 때까지 반복
        while(!q.isEmpty()){
            k = q.poll();
            // for문
            for(int i = 1; i <= n; i++) {
                // 조건에 따라 continue;
                if(visited[i] || !connected[k][i])
                    continue;
                // 큐에 넣기
                q.offer(i);
                // 방문표시
                visited[i] = true;
                arr[cnt++] = i;
            }
        }
    }
}
