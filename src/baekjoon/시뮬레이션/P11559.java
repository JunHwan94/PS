package 시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P11559 {
    static char[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[12][6];
        for (int i = 0; i < 12; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visited = new boolean[12][6];
        int totalCnt = 0;
        while(true) {
            // 뿌요 터뜨리기
            visited = new boolean[12][6];
            int boomCnt = 0;
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] != '.' && !visited[i][j]){
                        if(bfs(j, i, map[i][j])) boomCnt++;
                    }
                }
            }
            // 아무것도 안터지면 끝
            if(boomCnt == 0) break;
            totalCnt++;
            // 밑으로 떨어짐
            dropPuyo();
        }
        System.out.println(totalCnt);
    }

    private static void dropPuyo() {
        for (int x = 0; x < 6; x++) {
            Stack<Character> s = new Stack<>();
            for (int y = 0; y < 12; y++) {
                if(map[y][x] != '.') s.push(map[y][x]);
            }
            for (int y = 11; y >= 0; y--) {
                if(s.isEmpty()) map[y][x] = '.';
                else map[y][x] = s.pop();
            }
        }
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static boolean bfs(int x, int y, char puyo){
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        q.offer(y);
        visited[y][x] = true;
        Queue<Integer> pyq = new LinkedList<>();
        pyq.offer(x);
        pyq.offer(y);
        while(!q.isEmpty()) {
            x = q.poll();
            y = q.poll();
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if(yy < 0 || yy >= 12 || xx < 0 || xx >= 6 || visited[yy][xx]) continue;
                if(map[yy][xx] == puyo){
                    pyq.offer(xx);
                    pyq.offer(yy);
                    q.offer(xx);
                    q.offer(yy);
                    visited[yy][xx] = true;
                }
            }
        }

        // 터뜨릴 뿌요들 찾음
        if(pyq.size() >= 8){
            while(!pyq.isEmpty()){
                x = pyq.poll();
                y = pyq.poll();
                map[y][x] = '.';
            }
            return true;
        }

        return false;
    }
}