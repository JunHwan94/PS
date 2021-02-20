package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            StringTokenizer token;
            StringBuilder tsb = new StringBuilder();
            for(int n = 0; n < N; n++){
                token = new StringTokenizer(br.readLine());
                char c = token.nextToken().charAt(0);
                int cnt = Integer.parseInt(token.nextToken());
                while(cnt > 0) {
                    if (tsb.length() == 10) {
                        tsb.append('\n');
                        sb.append(tsb);
                        tsb.delete(0, tsb.length());
                    }
                    tsb.append(c);
                    cnt--;
                }
                if(n == N - 1) sb.append(tsb);
            }
            System.out.println("#" + t + "\n" + sb);
        }
    }
}