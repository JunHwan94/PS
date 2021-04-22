package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P5604 { // 구간합
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T ; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long start = Long.parseLong(st.nextToken());
            long end = Long.parseLong(st.nextToken());
            long[] sums = new long[9 * 14 + 1];
            for (int i = 1; i < sums.length; i++) {
                sums[i] = i;
            }

            long result = 0;
            int idx = getSum(start);
            // 처음 ~ 처음과 가까운 10의 배수
            // 합의 처음값 빼고 다음값 더하면서 result에 더하기
            // 마지막과 가까운 10의 배수 ~ 마지막
            for(long i = start; i <= end; i++){
                if(i % 10 == 0) idx = getSum(i);
                result += sums[idx++];
            }

            System.out.println("#" + t + " " + result);
        }
    }

    static int getSum(long l){
        int res = 0;
        for (int c : String.valueOf(l).toCharArray()) {
            res += c - '0';
        }
        return res;
    }
}