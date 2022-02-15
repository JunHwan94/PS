package baekjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2573 {
    static class Node {
        int x, y, bCnt;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int[][] glacier;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        glacier = new int[N][M];
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                glacier[i][j] = stoi(st.nextToken());
                if(glacier[i][j] > 0) {
                    nodes.add(new Node(j, i));
                }
            }
        }

        int year = 1;
        while(true){
            Queue<Node> q = new ArrayDeque<>(nodes);
            Queue<Node> dq = new ArrayDeque<>();
            while(!q.isEmpty()){
                Node node = q.poll();
                // 바다에 닿는 면적 수 세기
                for (int i = 0; i < 4; i++) {
                    int xx = node.x + dx[i];
                    int yy = node.y + dy[i];
                    if(xx < 0 || xx >= M || yy < 0 || yy >= N){
                        continue;
                    }
                    // 0이면 바다에 닿음
                    if(glacier[yy][xx] == 0) {
                        node.bCnt++;
                    }
                }
                dq.offer(node);
            }

            while(!dq.isEmpty()){
                Node node = dq.poll();
                int x = node.x;
                int y = node.y;
                glacier[y][x] -= node.bCnt;
                // 소멸
                if(glacier[y][x] <= 0){
                    nodes.remove(node);
                }
                node.bCnt = 0;

                // 음수 되면 0으로
                if(glacier[y][x] < 0){
                    glacier[y][x] = 0;
                }
            }

            visited = new boolean[N][M];
            numbered = new int[N][M];
            // 덩어리 개수 세기
            int num = 0;
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(glacier[i][j] != 0){
                        cnt++;
                        if(!visited[i][j]) {
                            bfs(++num, j, i);
                        }
                    }
                }
            }
            if(cnt == 0){
                break;
            }
            if(num > 1){
                System.out.println(year);
                return;
            }

            year++;
        }


        System.out.println(0);
    }

    static int[][] numbered;
    static boolean[][] visited;
    static void bfs(int num, int sx, int sy){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(sx);
        q.offer(sy);
        while(!q.isEmpty()){
            int x = q.poll();
            int y = q.poll();
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if(xx < 0 || xx >= M || yy < 0 || yy >= N){
                    continue;
                }
                if(visited[yy][xx] || glacier[yy][xx] == 0){
                    continue;
                }
                visited[yy][xx] = true;
                numbered[yy][xx] = num;
                q.offer(xx);
                q.offer(yy);
            }
        }
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
