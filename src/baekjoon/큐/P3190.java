package baekjoon.큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P3190 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] field = new int[N][N];
        int aCnt = Integer.parseInt(br.readLine());
        Queue<int[]> aq = new LinkedList<>();
        StringTokenizer token;
        for(int i = 0; i < aCnt; i++){
            token = new StringTokenizer(br.readLine());
            aq.offer(new int[]{Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken())});
        }

        int cCnt = Integer.parseInt(br.readLine());
        int[] cSec = new int[cCnt];
        char[] cArr = new char[cCnt];
        for(int i = 0; i < cCnt; i++){
            token = new StringTokenizer(br.readLine());
            cSec[i] = Integer.parseInt(token.nextToken());
            cArr[i] = token.nextToken().toCharArray()[0];
        }

        int sec = 0, dir = 0;
        int sx = 0, sy = 0;
        int[] dx = {1, 0, -1, 0}; // 우하좌상
        int[] dy = {0, 1, 0, -1};
//        List<>posList
        while(!aq.isEmpty()){

        }

        System.out.println(sec);
    }
}
