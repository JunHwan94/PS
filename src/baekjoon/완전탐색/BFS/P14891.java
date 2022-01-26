package baekjoon.완전탐색.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14891 {
    static boolean[] canRotate = new boolean[4];
    static List<Integer>[] stooth = new List[4];
    static int[] dirs = {1, 1, 1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int score = 0;
        // 톱니 4개 입력
        boolean isOver = true;
        for(int i = 0; i < 4; i++){
            String line = br.readLine();
            stooth[i] = new LinkedList<>();
            for(int j = 0; j < 8; j++) {
                stooth[i].add(line.charAt(j) - '0');
                if(line.charAt(j) == '0') isOver = false;
            }
        }
        if(isOver) {
            System.out.println(15);
            return;
        }
        // 명령 횟수 입력
        int cmdCnt = Integer.parseInt(br.readLine());
        // 명령 수행
        StringTokenizer token;
        for(int i = 0; i < cmdCnt; i++){
            token = new StringTokenizer(br.readLine());
            int sNum = Integer.parseInt(token.nextToken()) - 1;
            int dir = Integer.parseInt(token.nextToken());
            bfs(sNum, dir); // 회전 가능 여부 검사
            for(int j = 0; j < 4; j++) {
                if (canRotate[j]) {
                    if(dirs[j] == 1) stooth[j].add(0, stooth[j].remove(7));
                    else stooth[j].add(7, stooth[j].remove(0));
                }
            }
            canRotate = new boolean[4];
        }

        for(int i = 0; i < 4; i++) {
            if (stooth[i].get(0) == 1) score += 1 << i;
        }
        // 점수 출력
        System.out.println(score);
    }

    static void bfs(int sNum, int dir){
        canRotate[sNum] = true;
        dirs[sNum] = dir;
        Queue<Integer> q = new LinkedList<>();
        q.offer(sNum);
        while(!q.isEmpty()) {
            int sx = q.poll();
            int snx = sx - 1; // 왼쪽 톱니바퀴 검사
            if (!(snx < 0 || snx >= 4 || canRotate[snx])){
                if (stooth[snx].get(2).equals(stooth[sx].get(6))) { // 지금 톱니와 다음 톱니 같은 극이면 회전 불가
                    canRotate[snx] = false;
                }else if (!canRotate[sx]){
                    canRotate[snx] = false; // 다른 극이어도 지금 톱니가 회전 불가면 다음도 회전 불가
                }else {
                    canRotate[snx] = true;
                    q.offer(snx);
                    dirs[snx] = dirs[sx] * -1; // 방향 설정
                }
            }
            int bnx = sx + 1; // 오른쪽 톱니바퀴 검사
            if(!(bnx < 0 || bnx >= 4 || canRotate[bnx])) {
                if (stooth[bnx].get(6).equals(stooth[sx].get(2))) {
                    canRotate[bnx] = false;
                }else if (!canRotate[sx]){
                    canRotate[snx] = false;
                }else {
                    canRotate[bnx] = true;
                    q.offer(bnx);
                    dirs[bnx] = dirs[sx] * -1;
                }
            }
        }
    }
}