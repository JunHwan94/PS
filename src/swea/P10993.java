package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10993 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer token;
        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            int[] xs = new int[N];
            int[] ys = new int[N];
            int[] ss = new int[N];
            for(int n = 0; n < N; n++) {
                token = new StringTokenizer(br.readLine());
                xs[n] = Integer.parseInt(token.nextToken());
                ys[n] = Integer.parseInt(token.nextToken());
                ss[n] = Integer.parseInt(token.nextToken());
            }

            char[] rArr = new char[N];
            for(int i = 0; i < N; i++){
                double max = -1;
                double[] rcvs = new double[N];
                for (int j = 0; j < N; j++) {
                    if(i == j) continue;
                    double rcv = ss[j] / (Math.pow(xs[j] - xs[i], 2) + Math.pow(ys[j] - ys[i], 2));

                    // 군사력보다 받는 영향력이 크면 저장
                    if(ss[i] < rcv){
                        rcvs[j] = rcv;
                        max = Math.max(max, rcv);
                    }
                }

                // 자신에게 영향력을 행사하는 도시가 있으면 수행
                int cnt = 0;
                int mCity = -1;
                if(max > -1) {
                    for (int j = 0; j < N; j++) {
                        if(rcvs[j] == max) {
                            cnt++;
                            mCity = j + 1;
                        }
                    }
                    // 영향받는 도시 1개면 그 도시 따르기, 도시 번호 출력
                    if(cnt == 1){
                        rArr[i] = (char)(mCity + '0');
                    }else{ // 공화제 D
                        rArr[i] = 'D';
                    }
                }else rArr[i] = 'K'; // 군주제 K
            }

            for (int j = 0; j < N; j++) {
                for(int i = 0; i < N; i++){
                    if(rArr[i] != 'K' && rArr[i] != 'D'){
                        if(rArr[rArr[i] - '0' - 1] != 'K' && rArr[rArr[i] - '0' - 1] != 'D')
                            rArr[i] = rArr[rArr[i] - '0' - 1];
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                sb.append(rArr[i]).append(" ");
            }
            System.out.println("#" + t + " " + sb);
            sb.delete(0, sb.length());
        }
    }
}
