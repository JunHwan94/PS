package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2667 {
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static List<Integer> cntList;
    static String[] area;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        area = new String[n];
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            area[i] = br.readLine();
        }

        cntList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && area[i].charAt(j) == '1')
                    bfs(i, j);
            }
        }
        sb.append(cntList.size()).append("\n");

        Queue<Integer> pq = new PriorityQueue<>(cntList);
        while(!pq.isEmpty())
            sb.append(pq.poll()).append("\n");
        System.out.println(sb);
    }

    static void bfs(int x, int y){
        int cnt = 0;
        visited[x][y] = true;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(x, y));

        while(!q.isEmpty()) {
            x = q.peek().first;
            y = q.peek().second;
            q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue;
                if(area[nx].charAt(ny) == '0' || visited[nx][ny])
                    continue;

                q.offer(new Pair(nx, ny));
                visited[nx][ny] = true;
                cnt++;
            }
        }
        cnt++;
        if(cnt > 0) cntList.add(cnt);
    }

    static class Pair{
        int first;
        int second;

        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
}
