package baekjoon.완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 퇴사
public class P14501 {
    static int N;
    static int[] days;
    static int[] prices;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        days = new int[N];
        prices = new int[N];
        for(int n = 0; n < N; n++){
            StringTokenizer token = new StringTokenizer(br.readLine());
            days[n] = Integer.parseInt(token.nextToken());
            prices[n] = Integer.parseInt(token.nextToken());
        }
        selectConsult(0, 0, 0);
        System.out.println(max);
    }

    static void selectConsult(int cnt, int day, int p){
        if(cnt >= N){
            max = Math.max(p, max);
            return;
        }

        int tCnt = cnt + days[cnt];
        // 만약 선택하면 지금 선택한 상담에 걸리는 일수를 더해서 다음 선택할 상담으로 건너뛴다
        // 건너뛰는 위치가 인덱스 퇴사 이후면 진행못하므로 금액에 더하지 않는다
        selectConsult(tCnt, day + days[cnt], tCnt > N ? p : p + prices[cnt]);

        selectConsult(cnt + 1, day, p);
    }
}