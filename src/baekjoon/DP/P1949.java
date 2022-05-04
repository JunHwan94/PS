package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1949 {
    static class Node{
        int pop;
        List<Integer> nexts = new ArrayList<>();

        Node(int pop){
            this.pop = pop;
        }
    }

    static int N;
    static Node[] villages;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        villages = new Node[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            villages[i] = new Node(stoi(st.nextToken()));
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            villages[a].nexts.add(b);
            villages[b].nexts.add(a);
        }

        dp = new int[2][N + 1];
        visited = new boolean[N + 1];

        dfs(1);

        System.out.println(Math.max(dp[0][1], dp[1][1]));
    }

    static int[][] dp;
    static boolean[] visited;
    static void dfs(int cur){
        if(visited[cur]){
            return;
        }

        visited[cur] = true;
        dp[0][cur] = 0;
        dp[1][cur] = villages[cur].pop;

        for (int next : villages[cur].nexts){
            if(visited[next]){
                continue;
            }
            dfs(next);
            // 일반 경우
            dp[0][cur] += Math.max(dp[0][next], dp[1][next]);
            // 우수 경우
            dp[1][cur] += dp[0][next];
        }
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
