package baekjoon.분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1725 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] histogram = new int[N];
        int[] areas = new int[N];
        boolean[] bs = new boolean[N];
//        int max = 0;
        int min = 0;
        boolean minCon = true;
        for(int i = 0; i < N; i++){
            bs[i] = true;
            histogram[i] = Integer.parseInt(br.readLine());
            // 첫번째는 높이를 넓이로 넣음
            if(i == 0) areas[i] = histogram[i];
            else {
                for(int j = 0; j <= i; j++){
                    // 크거나 같은 높이가 계속되면 그 높이만큼 더해줌
                    if(bs[j] && histogram[j] <= histogram[i]){
                        areas[j] += histogram[j];
//                        max = Math.max(areas[j], max);
                    }else{ // 작은높이 나오면 넓이 계산 중단
                        bs[j] = false;
                    }
                }
            }
            if(histogram[i] > 0 && minCon) min++;
            else minCon = false;
        }
        Arrays.sort(areas);
        System.out.println(Math.max(areas[N - 1], min));
    }
}
