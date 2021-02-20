package swea;

import java.io.*;
import java.util.StringTokenizer;

public class P11285 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int[] circles = {20, 40, 60, 80, 100, 120, 140, 160, 180, 200};
        double dist;
        for(int t = 1; t <= T; t++){
            // 화살 수
            int N = Integer.parseInt(br.readLine());
            int score = 0;
            for(int n = 0; n < N; n++) {
                StringTokenizer token = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(token.nextToken());
                int y = Integer.parseInt(token.nextToken());
                // 거리 200 밖으로 나가면 0점
                dist = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
                if (dist > 200d) continue;
                // 꽂힌 위치보다 큰 원 반지름으로 점수 계산
                for (int i = 0; i < 10; i++) {
                    if (circles[i] >= dist) {
                        score += (220 - circles[i]) / 20;
                        break;
                    }
                }
            }
            bw.write("#" + t + " " + score + "\n");
        }
        bw.flush();
    }
}