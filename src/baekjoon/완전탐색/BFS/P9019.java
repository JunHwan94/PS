package baekjoon.완전탐색.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P9019 {
    static class NumCmd{
        int n;
        StringBuilder cmd = new StringBuilder();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = stoi(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = stoi(st.nextToken());
            int B = stoi(st.nextToken());
            bfs(A, B);
        }
    }

    static void bfs(int A, int B){
        boolean[] visited = new boolean[10000];

        String dslr = "DSLR";
        Queue<NumCmd> q = new ArrayDeque<>();
        NumCmd first = new NumCmd();
        first.n = A;
        q.offer(first);
        visited[A] = true;
        while(!q.isEmpty()){
            NumCmd nc = q.poll();
            if(nc.n == B){
                System.out.println(nc.cmd);
                break;
            }

            for (int i = 0; i < 4; i++) {
                NumCmd newNc = new NumCmd();
                newNc.cmd.append(nc.cmd);

                if(dslr.charAt(i) == 'D') {
                    newNc.n = D(nc.n);
                    newNc.cmd.append('D');
                }else if(dslr.charAt(i) == 'S'){
                    newNc.n = S(nc.n);
                    newNc.cmd.append('S');
                }else if(dslr.charAt(i) == 'L'){
                    newNc.n = L(nc.n);
                    newNc.cmd.append('L');
                }else{
                    newNc.n = R(nc.n);
                    newNc.cmd.append('R');
                }

                if(visited[newNc.n]){
                    continue;
                }

                visited[newNc.n] = true;

                q.offer(newNc);
            }
        }
    }

    // D : n을 2배로, 결과가 9999 초과면 1000으로 나눈 나머지 저장
    static int D(int n){
        n *= 2;
        if(n > 9999){
            n %= 10000;
        }
        return n;
    }

    static int S(int n){
        if(n == 0){
            return 9999;
        }
        return n - 1;
    }

    static int R(int n){
        int x = n / 10;
        int y = (n % 10) * 1000;
        return x + y;
    }

    static int L(int n){
        int x = n / 1000;
        int y = (n % 1000) * 10;
        return x + y;
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
