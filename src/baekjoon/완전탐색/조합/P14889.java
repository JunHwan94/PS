package baekjoon.완전탐색.조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 조합
// 스타트와 링크
public class P14889 {
    static int N;
    static int[][] stats;
    static int[] sArr, lArr;
    static boolean[] visited;
    static int min = 100;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stats = new int[N][N];
        sArr = new int[N / 2];
        lArr = new int[N / 2];
        visited = new boolean[N + 1];

        for(int i = 0; i < N; i++){
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) // 각 번호별 대응 스탯 입력
                stats[i][j] = Integer.parseInt(token.nextToken());
        }

        comb(0, 0);
        System.out.println(min);
    }

    static void comb(int cnt, int start){
        if(cnt == N / 2){ // 전체 중 절반만 뽑기
            int sStat = 0, lStat = 0;

            for(int i = 0; i < N / 2; i++){ // 첫번째 팀 능력치 계산
                for(int j = 0; j < N / 2; j++)
                    sStat += stats[sArr[i]][sArr[j]];
            }

            int lCnt = 0;
            for(int i = 0; i < N; i++) // 두번째 팀 편성
                if(!visited[i]) lArr[lCnt++] = i;

            for(int i = 0; i < N / 2; i++){ // 두번째 팀 능력치 계산
                for(int j = 0; j < N / 2; j++)
                    lStat += stats[lArr[i]][lArr[j]];
            }

            min = Math.min(min, Math.abs(sStat - lStat)); // 최소값 넣기
            return;
        }

        for(int i = start; i < N; i++){
            visited[i] = true;
            sArr[cnt] = i; // 첫번째 팀 편성
            comb(cnt + 1, i + 1);
            visited[i] = false;
        }
    }
}