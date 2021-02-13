package baekjoon.완전탐색.순열;
// n과 m (9)
// 못품ㅠ
import java.io.*;
import java.util.*;

public class P15663 {
    static int n;
    static int r;
    static int[] arr;
    static List<Integer> list = new ArrayList<>();
    static Set<String> set = new TreeSet<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        n = Integer.parseInt(token.nextToken());
        r = Integer.parseInt(token.nextToken());
        arr = new int[r];
        visited = new boolean[n];

        token = new StringTokenizer(br.readLine());
        while(token.hasMoreTokens())
            list.add(Integer.parseInt(token.nextToken()));
        Collections.sort(list);
        permutation(0);

        for(String s : set){
            System.out.println(s);
        }
    }

    static void permutation(int depth){
        if(depth == r){
            StringBuilder tsb = new StringBuilder();
            for(int i = 0; i < r; i++) {
                tsb.append(arr[i]).append(" ");
            }
            set.add(tsb.toString().trim());
            return;
        }

        for(int i = 0; i < list.size(); i++){
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = list.get(i);
                permutation(depth + 1);
                visited[i] = false;
            }
        }
    }
}