package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2798 {
    static int[] arr;
    static boolean[] visited = new boolean[100];
    static Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    static int m = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        arr = new int[n];
        token = new StringTokenizer(br.readLine());
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(token.nextToken());
        }

        dfs(0, 0);
        System.out.println(pq.poll());
        br.close();
    }
    /**
     * @param sum 현재 뽑은 값들의 합
     * @param depth 현재 탐색 깊이
     */
    static void dfs(int sum, int depth) {
        if (depth == 3) {
            if(sum <= m) pq.offer(sum);
            return;
        }
        for(int i = 0; i < arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(sum + arr[i], depth + 1);
                visited[i] = false;
            }
        }
    }
}
