package baekjoon.완전탐색.DFS;

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
        br.close();
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

// 2309 일곱 난쟁이
//public class Main {
//    static int[] arr;
//    static Stack<Integer> stack = new Stack<>();
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        arr = new int[9];
//        for(int i=0; i<9; i++) {
//            arr[i] = Integer.parseInt(br.readLine());
//        }
//        Arrays.sort(arr);
//        solve(0, 0, 0);
//    }
//    static void solve(int pos, int cnt, int sum) {
//        if(pos == 9) {
//            if(cnt == 7 && sum==100) {
//                for(int x : stack) {
//                    System.out.println(x);
//                }
//                System.exit(0);
//            }
//            return;
//        }
//        stack.push(arr[pos]);
//        solve(pos+1, cnt+1, sum+arr[pos]);
//        stack.pop();
//        solve(pos+1, cnt, sum);
//        return;
//    }
//}