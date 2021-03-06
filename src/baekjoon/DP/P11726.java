package baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11726 {
    static long[] tiles;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tiles = new long[1001];
        tiles[1] = 1;
        tiles[2] = 2;
        int N = Integer.parseInt(br.readLine());
        System.out.println(tile(N));
    }

    static long tile(int n){
        if(n <= 2) return tiles[n];
        if(tiles[n - 1] == 0) tiles[n - 1] = tile(n - 1);
        if(tiles[n - 2] == 0) tiles[n - 2] = tile(n - 2);
        return tiles[n] = (tiles[n - 1] + tiles[n - 2]) % 10007;
    }
}