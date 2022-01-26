package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P15686 {
    static int N, M, cShopCount;
    static int[][] city;
    static List<Loc> cShops;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        city = new int[N][N];
        cShops = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = stoi(st.nextToken());
                if(city[i][j] == 2) {
                    cShops.add(new Loc(j, i)); // 닭집 위치 저장
                }
            }
        }

        cShopCount = cShops.size();
        min = 100000000;

        if (cShopCount == M){ // 폐업할 곳 없음 바로계산
            selectedLoc = cShops.toArray(new Loc[0]);
            calculateChickenDist();
        }else {// 남길 곳 조합
            selectedLoc = new Loc[M]; // 남길 곳 위치
            comb(0, 0);
        }

        System.out.println(min);
    }

    static void calculateChickenDist(){
        // 치킨거리 계산
        int cDist = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int minDist = 999;
                if (city[i][j] == 1) {
                    // 가장 작은 치킨거리 저장
                    for (Loc loc : selectedLoc) {
                        minDist = Math.min(minDist, Math.abs(j - loc.x) + Math.abs(i - loc.y));
                    }
                }
                if (minDist < 999) {
                    cDist += minDist;
                }
            }
        }

        min = Math.min(min, cDist);
    }

    static Loc[] selectedLoc;
    static int min;

    static void comb(int start, int n){
        if(n == M){
            calculateChickenDist();
            return;
        }

        for (int i = start; i < cShopCount; i++) {
            selectedLoc[n] = cShops.get(i);
            comb(i + 1, n + 1);
        }
    }

    public static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static class Loc {
        int x, y;
        public Loc(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
