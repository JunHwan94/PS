package baekjoon.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P3190 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int aCnt = Integer.parseInt(br.readLine());
        List<Pair> apples = new ArrayList<>();
        StringTokenizer token;
        for(int i = 0; i < aCnt; i++){
            token = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(token.nextToken());
            int x = Integer.parseInt(token.nextToken());
            apples.add(new Pair(x, y));
        }

        int cCnt = Integer.parseInt(br.readLine());
        Map<Integer, Character> cMap = new TreeMap<>();
        for(int i = 0; i < cCnt; i++){
            token = new StringTokenizer(br.readLine());
            cMap.put(Integer.parseInt(token.nextToken()), token.nextToken().charAt(0));
        }

        int sec = 0, dir = 0;
        boolean over = false;
        int[] dx = {1, 0, -1 ,0};
        int[] dy = {0, 1, 0 ,-1};
        Deque<Pair> posQueue = new LinkedList<>();
        posQueue.offerFirst(new Pair(1, 1)); // First : 머리
        while(true){
            if(dir == -1) dir = 3;
            int nx = posQueue.peekFirst().x + dx[dir];
            int ny = posQueue.peekFirst().y + dy[dir];
            // 범위 이탈하면 게임 끝
            if(nx > N || nx < 1 || ny > N || ny < 1){
                sec++;
                break;
            }
            // 뱀이 다음 위치를 포함하는지 검사
            // 포함하면 게임 끝
            for(Pair p : posQueue){
                if(p.x == nx && p.y == ny){
                    sec++;
                    over = true;
                }
            }
            // 포함하지 않으면 머리에 추가
            if(over) break;
            else posQueue.offerFirst(new Pair(nx, ny));

            // 사과 먹었는지 검사
            int aIdx = -1;
            for(int i = 0; i < apples.size(); i++) {
                if (apples.get(i).x == nx && apples.get(i).y == ny) {
                    aIdx = i;
                    break;
                }
            }
            // 사과 먹었으면 꼬리 유지
            if(aIdx != -1)
                apples.remove(aIdx); // 사과 ㅂㅂ
            else posQueue.pollLast(); // 꼬리 ㅂㅂ
            sec++;

            // 맨앞 명령어가 지금 실행돼야 하는지
            int rKey = -1;
            if(!cMap.isEmpty() && sec == (int)cMap.keySet().toArray()[0]){
                switch (cMap.get(sec)) {
                    case 'L': // 왼쪽 방향전환
                        dir = (dir - 1) % 4;
                        rKey = sec;
                        break;
                    case 'D': // 오른쪽 방향전환
                        dir = (dir + 1) % 4;
                        rKey = sec;
                }
            }
            if(rKey != -1) cMap.remove(rKey);
        }

        System.out.println(sec);
    }

    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}