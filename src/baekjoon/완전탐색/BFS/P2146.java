import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2146 {
    static int N, min;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());

        map = new int[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }

        // 번호붙이기
        count = 1;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] > 0) {
                    numbering(j, i);
                    count++;
                }
            }
        }

        min = Integer.MAX_VALUE;
        // 바다와 맞닿은 점에서 다리 만들어보기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] > 0){
                    buildBridge(j, i, map[i][j]);
                }
            }
        }

        System.out.println(min);
    }

    static int count;
    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    static boolean visited[][];
    static void numbering(int x, int y){
        map[y][x] = count;

        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        q.offer(y);

        while(!q.isEmpty()){
            x = q.poll();
            y = q.poll();
            for(int k = 0; k < 4; k++){
                int xx = x + dx[k];
                int yy = y + dy[k];
                if(xx < 0 || xx >= N || yy < 0 || yy >= N){
                    continue;
                }
                if(visited[yy][xx]){
                    continue;
                }
                if(map[yy][xx] == 0){
                    continue;
                }
                visited[yy][xx] = true;
                map[yy][xx] = count;
                q.offer(xx);
                q.offer(yy);
            }
        }
    }

    static int[][] bridgeMap;
    static void buildBridge(int x, int y, int no){
        bridgeMap = new int[N][N];
        boolean[][] visited = new boolean[N][N];
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        q.offer(y);

        Queue<Integer> pq = new PriorityQueue<>();
        while(!q.isEmpty()){
            x = q.poll();
            y = q.poll();
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if(xx < 0 || xx >= N || yy < 0 || yy >= N){
                    continue;
                }
                if(visited[yy][xx]){
                    continue;
                }
                if(map[yy][xx] == no){
                    continue;
                }
                // 다른 섬에 도착
                if(0 < map[yy][xx] && map[yy][xx] != no){
                    pq.offer(bridgeMap[y][x]);
                }
                visited[yy][xx] = true;
                bridgeMap[yy][xx] = bridgeMap[y][x] + 1;
                q.offer(xx);
                q.offer(yy);
            }
        }
        if(!pq.isEmpty()) {
            min = Math.min(min, pq.poll());
        }
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
