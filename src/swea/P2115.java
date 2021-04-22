package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P2115 {
    static int N, M, C;
    static int[][] field;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = stoi(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = stoi(st.nextToken());
            M = stoi(st.nextToken());
            C = stoi(st.nextToken());
            field = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    field[i][j] = stoi(st.nextToken());
                }
            }

            // 1. 위치 선택
            selected = new int[N][N];
            supSet(0, 0, 0);

            System.out.println("#" + t + " " + hPriceSum);
        }
    }

    static int[][] selected;
    static void supSet(int cnt, int x, int y){
        if(cnt == 2 || y == N - 1 || x > N - 1){
            harvest();
            return;
        }

        if(x >= N - 1) {
            x = 0;
            y++;
        }

        if(M == 1) return;
        supSet(cnt, x + 1, y);
        selected[cnt][0] = x;
        selected[cnt][1] = y;
        supSet(cnt + 1, x + M - 1, y);
    }

    static int hPriceSum;
    private static void harvest() {
        int x1 = selected[0][0];
        int y1 = selected[0][1];
        int x2 = selected[1][0];
        int y2 = selected[1][1];
        if(x1 == x2 && y1 == y2) return;

        hMax = 0;
        hPriceSum = 0;
        getMaxSum(x1 + M - 1, x1, y1, 0, new ArrayList<>());
        hPriceSum += price;

        hMax = 0;
        getMaxSum(x2 + M - 1, x2, y2, 0, new ArrayList<>());
        hPriceSum += price;
    }

    static int hMax, price;
    static void getMaxSum(int mx, int x, int y, int sum, List<Integer> list){
        if(sum > C) return;
        if(mx == x || x == N - 1) {
            if(hMax < sum){
                hMax = sum;
                price = 0;
                for(int i : list){
                    price += i * i;
                }
            }
//            for(int i : list){
//                System.out.print(i + " ");
//            }
//            System.out.println();
            return;
        }
        getMaxSum(mx, x + 1, y, sum, list);
        list.add(field[y][x]);
        getMaxSum(mx, x + 1, y, sum + field[y][x], list);
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}