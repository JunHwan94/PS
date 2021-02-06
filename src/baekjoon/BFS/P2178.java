package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178 {
    static int n;
    static int m;
    static int[][] maze;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        n = Integer.parseInt(token.nextToken());
        m = Integer.parseInt(token.nextToken());
        maze = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            char[] line = br.readLine().toCharArray();
            for(int j = 0; j < m; j++){
                maze[i][j] = line[j] - '0';
            }
        }

        bfs();

        System.out.println(maze[n-1][m-1]);
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static void bfs(){
        // 방문 표시
        visited[0][0] = true;
        // 큐에 넣기
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0));
        while(!q.isEmpty()){
            int x = q.peek().first;
            int y = q.poll().second;
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= m || ny < 0 || ny >= n || maze[ny][nx] == 0)
                    continue;
                if(visited[ny][nx]) continue;
                maze[ny][nx] = maze[y][x] + 1;
                q.offer(new Pair(nx, ny));
                visited[ny][nx] = true;
            }
        }
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
