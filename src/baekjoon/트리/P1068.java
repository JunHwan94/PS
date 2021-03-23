package baekjoon.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1068 {
    static int N;
    static int[][] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        tree = new int[N][3]; // 3개짜리 배열의 배열로
        for(int i = 0; i < N; i++){
            tree[i] = new int[3];
            for (int j = 0; j < 3; j++) {
                tree[i][j] = -2;
            }
        }
        StringTokenizer token = new StringTokenizer(br.readLine());
        int root = 0;
        for(int i = 0; i < N; i++){
            int n = stoi(token.nextToken());
            if(n == -1) {
                root = i;
                tree[i][0] = -1;
            }else{
                if(tree[n][1] == -1){
                    tree[n][1] = 1;
                    tree[i][0] = n;
                }else{
                    tree[n][2] = 1;
                    tree[i][0] = n;
                }
            }
        }

        inOrder(stoi(br.readLine()));
        int cnt = 0;
        for(int i = 2; i < N; i++){
            // 부모가 -1이 아니고 자신이 -1이 아니고 자식이 둘다 -2일때 리프
            if(tree[i][0] != -2 && tree[i][1] == -2 && tree[i][2] == -2) {
                cnt++;
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(tree[i]));
        }
        System.out.println(cnt);
    }

    static void inOrder(int i){
        if(i >= tree.length - 1 || i < 0) return;
        inOrder(tree[i][1]);
        tree[i][0] = -2;
        inOrder(tree[i][2]);
    }

    static int stoi(String s){ return Integer.parseInt(s); }
}