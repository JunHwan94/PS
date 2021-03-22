package baekjoon.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1068 {
    static int N;
    static ArrayList<Integer>[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        tree = new ArrayList[N]; // 3개짜리 배열의 배열로
        for(int i = 0; i < N; i++){
            tree[i] = new ArrayList<>();
        }
        StringTokenizer token = new StringTokenizer(br.readLine());
        int root = 0;
        for(int i = 0; i < N; i++){
            int n = stoi(token.nextToken());
            if(n == -1) root = i;
            else tree[n].add(1);
        }

        Arrays.stream(tree).forEach(System.out::println);
//        System.out.println();

        inOrder(stoi(br.readLine()));
        int cnt = 0;
        for(int i = 1; i < N; i++){
            // 부모가 -1이 아니고 자신이 -1이 아니고 자식이 둘다 -1일때 리프
//            if(tree[i] != -1 && tree[i * 2 + 1] == -1 && tree[i * 2 + 2] == -1) {
//                if(i > 2 && tree[i] == 0) continue;
//                cnt++;
//            }
        }
        System.out.println(Arrays.toString(tree));
        System.out.println(cnt);
    }

    static void inOrder(int i){
        if(i >= tree.length) return;
        inOrder(i * 2 + 1);
        tree[i].clear();
        inOrder(i * 2 + 2);
    }

    static int stoi(String s){ return Integer.parseInt(s); }
}