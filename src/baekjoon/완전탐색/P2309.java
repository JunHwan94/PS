package baekjoon.완전탐색;

import java.io.*;
import java.util.Arrays;

public class P2309 {
    static int[] dwarfs = new int[9];
    static boolean[] visited = new boolean[9];
    static int[] sDwarfs = new int[7];
    static boolean isOver = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < dwarfs.length; i++){
            dwarfs[i] = Integer.parseInt(br.readLine());
        }
        selectDwarf(0, 0);
    }
    /**
     * @param sum 현재 뽑은 값들의 합
     * @param depth 현재 탐색 깊이
     */
    static void selectDwarf(int sum, int depth) {
        if(isOver) return;
        if (sum == 100 && depth == 7) { // 탐색 깊이 7이고 뽑은 난쟁이 키 합이 100일 때
            // 뽑은 난쟁이들 정렬해서 하나씩 출력
            Arrays.stream(sDwarfs).sorted().forEach(System.out::println);
            // 끝
            isOver = true;
            System.exit(1);
        } else if (depth > 6) {
            return;
        } else if (sum > 100){
            return;
        }
        for(int i = 0; i < dwarfs.length; i++){
            if(!visited[i]){
                visited[i] = true;
                sDwarfs[depth] = dwarfs[i];
                selectDwarf(sum + dwarfs[i], depth + 1);
                visited[i] = false;
            }
        }
    }
}
