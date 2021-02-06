package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7576 {
    static int n;
    static int m;
    static int[][] box;
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        m = Integer.parseInt(token.nextToken());
        n = Integer.parseInt(token.nextToken());
        box = new int[n][m];

        for(int i = 0; i < n; i++){ // 세로 y
            token = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){ // 가로 x
                box[i][j] = Integer.parseInt(token.nextToken());
                if(box[i][j] == 1){
                    q.offer(new Pair(j, i));
                }
            }
        }

        bfs();

        int max = 0;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(box[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, box[i][j]);
            }
        }
        System.out.println(max - 1);
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Pair> q = new LinkedList<>();
    static void bfs(){
        while(!q.isEmpty()){
            int x = q.peek().first;
            int y = q.poll().second;
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= m || ny < 0 || ny >= n)
                    continue;
                if(box[ny][nx] != 0)
                    continue;
                box[ny][nx] = box[y][x] + 1;
                q.offer(new Pair(nx, ny));
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
