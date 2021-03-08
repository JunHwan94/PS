package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11053 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int[] lengths = new int[N];
        for(int i = 0; i < N; i++) lengths[i] = 1; // 최소 길이 = 1

        int max = 1;
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(token.nextToken());
            for(int j = 0; j <= i; j++){
                // 작은 수의 인덱스에서 길이를 조회해서 + 1 한것에 max 하기
                if(nums[j] < nums[i]){
                    lengths[i] = Math.max(lengths[j] + 1, lengths[i]);
                    max = Math.max(lengths[i], max);
                }
            }
        }
        System.out.println(max);
    }
}
