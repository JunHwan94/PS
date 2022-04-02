package test.match;

import java.util.LinkedList;
import java.util.Queue;

public class P2 {
    public static void main(String[] args) {
        System.out.println(solution2(new String[]{"??b", "abc", "cc?"}));
        System.out.println(solution2(new String[]{"abcabcab", "????????"}));
        System.out.println(solution2(new String[]{"aa?"}));
    }

    static int answer;
    static char[] abc = {'a', 'b', 'c'};
    public static int solution2(String[] grid) {
        answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                if(grid[i].charAt(j) == '?'){
                    q.offer(j);
                    q.offer(i);
                }
            }
        }

        char[][] gridArr = new char[grid.length][grid[0].length()];
        for (int i = 0; i < gridArr.length; i++) {
            gridArr[i] = grid[i].toCharArray();
        }
        for (int i = 0; i < 3; i++) {
            setAlphabet(abc[i], new LinkedList<>(q), gridArr.clone());
        }

        return answer;
    }

    public static void setAlphabet(char c, Queue<Integer> q, char[][] grid){
        int x = q.poll();
        int y = q.poll();
        grid[y][x] = c;

        if(q.isEmpty()){
            if(checkAllConnected(grid)){
                answer++;
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            setAlphabet(abc[i], new LinkedList<>(q), grid.clone());
        }
    }

    static boolean[][] visited;
    public static boolean checkAllConnected(char[][] grid){
        // 각 알파벳들 모두 이어져있는지 확인
        for (int i = 0; i < 3; i++) {
            int cnt = 0;
            visited = new boolean[grid.length][grid[0].length];
            for (int y = 0; y < grid.length; y++) {
                for (int x = 0; x < grid[0].length; x++) {
                    if (grid[y][x] == abc[i] && !visited[y][x]) {
                        bfs(x, y, abc[i], grid);
                        cnt++;
                    }
                }
            }
//            System.out.print(abc[i] + "개수 : ");
//            System.out.println(cnt);
            if (cnt > 1) {
                return false;
            }
        }
        return true;
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void bfs(int x, int y, char c, char[][] grid){
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        q.offer(y);
        visited[y][x] = true;
        while(!q.isEmpty()){
            x = q.poll();
            y = q.poll();
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if(xx < 0 || xx >= visited[0].length || yy < 0 || yy >= visited.length){
                    continue;
                }
                if(visited[yy][xx] || grid[yy][xx] != c){
                    continue;
                }
                visited[yy][xx] = true;
                q.offer(xx);
                q.offer(yy);
            }
        }
    }
}
