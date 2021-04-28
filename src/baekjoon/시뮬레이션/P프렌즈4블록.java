package baekjoon.시뮬레이션;

import java.util.*;

public class P프렌즈4블록 {

    public static void main(String[] args) {
        System.out.println(solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
        System.out.println(solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
    }

    static int[] dx = {1, 1, 0};
    static int[] dy = {0, 1, 1};
    static int solution(int m, int n, String[] board){
        char[][] tBoard = new char[m][n];
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++)
            tBoard[i] = board[i].toCharArray();

        int result = 0;
        while(true) {
            // 높이 m - 2 까지, 너비 n - 2 까지
            for (int y = 0; y < m - 1; y++) {
                for (int x = 0; x < n - 1; x++) {
                    char c = tBoard[y][x];
                    if(c == '0') continue;

                    Queue<Integer> q = new LinkedList<>();
                    q.offer(x);
                    q.offer(y);
                    while(!q.isEmpty()) {
                        int x1 = q.poll();
                        int y1 = q.poll();

                        int cnt = 1;
                        // 오른쪽, 아래, 오른쪽아래 칸이 같은지 검사
                        for (int k = 0; k < 3; k++) {
                            int xx = x1 + dx[k];
                            int yy = y1 + dy[k];
                            if(xx >= n || yy >= m) continue;
                            if (tBoard[yy][xx] == c) cnt++;
                        }
                        // 4개가 같으면 블록 표시
                        if (cnt == 4) {
                            visited[y][x] = true;
                            for (int k = 0; k < 3; k++) {
                                int xx = x1 + dx[k];
                                int yy = y1 + dy[k];
                                visited[yy][xx] = true;
                                q.offer(xx);
                                q.offer(yy);
                            }
                        }
                    }
                }
            }

            // 칸 지우기, 갯수세기
            int rCnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(visited[i][j]) {
                        visited[i][j] = false;
                        tBoard[i][j] = '0';
                        rCnt++;
                    }
                }
            }
            result += rCnt;

            // 확인
//            for (int i = 0; i < tBoard.length; i++)
//                System.out.println(Arrays.toString(tBoard[i]));

            // 지운 칸 없으면 while 끝
            if(rCnt == 0) break;

            // 블록 내리기
            for (int i = 0; i < n; i++) {
                Stack<Character> stack = new Stack<>();
                for (int j = 0; j < m; j++) { // 위부터 0아닌 것들만 스택에 더함
                    char c = tBoard[j][i];
                    if(c != '0') stack.push(c);
                }
                // 높이 m 만큼 반복, 스택에 들어있는 것들 아래부터 채우기, 스택 원소 없어지면 0넣기
                for (int j = m - 1; j >= 0; j--)
                    tBoard[j][i] = stack.isEmpty() ? '0' : stack.pop();
            }
        }
        return result;
    }
}