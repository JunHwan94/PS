package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P5643 { // 키 순서 bfs
    static int N, M, cnt;
    static int[][] adj, radj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = stoi(br.readLine());
            M = stoi(br.readLine());
            adj = new int[N + 1][N + 1];
            radj = new int[N + 1][N + 1];

            StringTokenizer st;
            int i, j;
            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                i = stoi(st.nextToken());
                j = stoi(st.nextToken());

                radj[j][i] = adj[i][j] = 1;
            }

            int res = 0;
            for (int k = 1; k <= N; k++) {
                cnt = 0;
                bfs(k, adj, new boolean[N + 1]);
                bfs(k, radj, new boolean[N + 1]);
                if(cnt == N - 1) ++res;
            }

            System.out.println("#" + t + " " + res);
        }
    }

    // 카운팅
    static void bfs(int x, int[][] adj, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visited[x] = true;
        while(!q.isEmpty()){
            int k = q.poll();
            for (int i = 1; i <= N; i++) {
                if(!visited[i] && adj[k][i] == 1){
                    q.offer(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
