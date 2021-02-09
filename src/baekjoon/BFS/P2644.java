package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2644 {
    static int target;
    static int pCnt;
    static boolean[][] connected;
    static boolean[] visited;
    static int stoi(String s) { return Integer.parseInt(s); }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pCnt = stoi(br.readLine());
        connected = new boolean[pCnt + 1][pCnt + 1];
        visited = new boolean[pCnt + 1];
        StringTokenizer token = new StringTokenizer(br.readLine());
        int start = stoi(token.nextToken());
        target = stoi(token.nextToken());
        int cCnt = stoi(br.readLine());


        for(int i = 0; i < cCnt; i++){
            token = new StringTokenizer(br.readLine());
            int p = stoi(token.nextToken());
            int n = stoi(token.nextToken());
            connected[p][n] = true;
            connected[n][p] = true;
        }
        bfs(start);

        System.out.println(result == 0 ? -1 : result);
    }

    static int result;
    static void bfs(int p){
        visited[p] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{p, 0});

        while(!q.isEmpty()){
            p = q.peek()[0];
            int c = q.poll()[1];
            if(p == target){
                result = c;
                break;
            }
            for(int i = 1; i <= pCnt; i++){
                if(visited[i] || !connected[p][i]) continue;
                q.offer(new int[]{i, c + 1});
                visited[i] = true;
            }
        }
    }
}