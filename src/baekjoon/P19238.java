package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

public class P19238 {

    static int[][] map;
    static boolean[][] visited;
    static int n, m, fuel, tr, tc;
    static List<Passenger> passengers;
    static Passenger[][] passengerMap;
    static Function<String, Integer> stoi = Integer::parseInt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = stoi.apply(st.nextToken());
        m = stoi.apply(st.nextToken());
        fuel = stoi.apply(st.nextToken());

        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = stoi.apply(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        tr = stoi.apply(st.nextToken());
        tc = stoi.apply(st.nextToken());

//        passengers = new ArrayList<>();
        passengerMap = new Passenger[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = stoi.apply(st.nextToken());
            int c = stoi.apply(st.nextToken());
            int dr = stoi.apply(st.nextToken());
            int dc = stoi.apply(st.nextToken());
            passengerMap[r][c] = new Passenger(r, c, dr, dc);
//            passengers.add(passengerMap[r][c]);
        }

        int M = m;
        // 승객 태우기
        while(M > 0){
//            Queue<Passenger> pq = new PriorityQueue<>();

            // 다음 승객 선택 시간 줄여야하는데?
//            for (int i = 0; i < passengers.size(); i++) {
//                Passenger p = passengers.get(i);
//                p.calTpDist();
//                pq.offer(p);
//            }

            Passenger passenger = findPassenger();//pq.poll();
            // 승객이 목적지로 갈 수 없음
            if(passenger == null || passenger.dist == 0) {
                System.out.println(-1);
                return;
            }

            // 태우러 갈 수 있음
            if(passenger.tpDist >= 0) {
                System.out.println(passenger.r + " " + passenger.c);
//                passengers.remove(passenger);
                passengerMap[passenger.r][passenger.c] = null;
                // 승객 태우러 가는 동안 연료 태움
                fuel -= passenger.tpDist;
                tr = passenger.r;
                tc = passenger.c;
            }else{
                System.out.println(-1);
                return;
            }

            if(fuel <= 0){
                System.out.println(-1);
                return;
            }

            // 목적지 거리만큼 연료 소모
            fuel -= passenger.dist;
            // 도착 전 연료 바닥나면 못감
            if(fuel < 0){
                System.out.println(-1);
                return;
            }
            tr = passenger.destR;
            tc = passenger.destC;
            // 목적지에 도착하면 연료양은 쓴 양 * 2 만큼 추가
            fuel += passenger.dist * 2;

            M--;
        }

        System.out.println(fuel);
    }

    private static Passenger findPassenger() {
        boolean[][] visited = new boolean[n + 1][n + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(tr);
        q.offer(tc);
        visited[tr][tc] = true;
        while(!q.isEmpty()){
            int r = q.poll();
            int c = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                // 제공 좌표가 1부터시작함
                if(nr < 1 || nr > n || nc < 1 || nc > n) continue;
                if(visited[nr][nc] || map[nr][nc] == 1) continue;
                if(passengerMap[nr][nc] != null) return passengerMap[nr][nc];
                visited[nr][nc] = true;
                q.offer(nr);
                q.offer(nc);
            }
        }
        return null;
    }

    static int[] dc = {1, 0, -1, 0}, dr = {0, 1, 0, -1};
    static class Passenger implements Comparable<Passenger>{
        int r, c, destR, destC, dist, tpDist;

        public Passenger(int r, int c, int dr, int dc){
            this.r = r;
            this.c = c;
            this.destR = dr;
            this.destC = dc;
            calDist();
        }

        public void calDist(){
            int[][] distMap = new int[n + 1][n + 1];
            boolean[][] visited = new boolean[n + 1][n + 1];
            // 내 최단 거리 측정
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(r);
            q.offer(c);
            visited[r][c] = true;
            while(!q.isEmpty()){
                int r = q.poll();
                int c = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    // 제공 좌표가 1부터시작함
                    if(nr < 1 || nr > n || nc < 1 || nc > n) continue;
                    if(visited[nr][nc] || map[nr][nc] == 1) continue;
                    visited[nr][nc] = true;
                    distMap[nr][nc] = distMap[r][c] + 1;
                    q.offer(nr);
                    q.offer(nc);
                }
            }
            // 계산한 거리 저장
            // 도달못하면 0
            dist = distMap[destR][destC];
        }

        public void calTpDist(){
            if(tr == r && tc == c) {
                tpDist = 0;
                return;
            }
            int[][] distMap = new int[n + 1][n + 1];
            boolean[][] visited = new boolean[n + 1][n + 1];
            // 내 최단 거리 측정
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(tr);
            q.offer(tc);
            visited[tr][tc] = true;
            while(!q.isEmpty()){
                int r = q.poll();
                int c = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    // 제공 좌표가 1부터시작함
                    if(nr < 1 || nr > n || nc < 1 || nc > n) continue;
                    if(visited[nr][nc] || map[nr][nc] == 1) continue;
                    visited[nr][nc] = true;
                    distMap[nr][nc] = distMap[r][c] + 1;
                    q.offer(nr);
                    q.offer(nc);
                }
            }
            // 계산한 거리 저장
            // 도달못하면 -1
            tpDist = distMap[r][c];
            if(tpDist == 0) tpDist = -1;
        }

        @Override
        public boolean equals(Object obj) {
            return this.r == ((Passenger)obj).r && this.c == ((Passenger)obj).c;
        }

        @Override
        public int compareTo(Passenger o) {
            if(tpDist == o.tpDist){
                if(r == o.r) return c - o.c;
                return r - o.r;
            }
            return tpDist - o.tpDist;
        }
    }
}
