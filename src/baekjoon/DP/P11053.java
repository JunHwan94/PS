package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11053 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int[] lengths = new int[N];
        int max = 0;
        StringTokenizer token = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(token.nextToken());
            // 첫번째는 1로 넣음
            if(i == 0) lengths[i] = 1;
            else {
                for(int j = 0; j < i; j++){
                    // 큰 수가 나오면 1더해줌
                    if(nums[j] < nums[i]){
                        nums[j] = nums[i];
                        lengths[j]++;
                        max = Math.max(lengths[j], max);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(nums));
//        Arrays.sort(lengths);
        System.out.println(max);
    }
}
