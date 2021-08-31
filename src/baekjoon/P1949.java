package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class P1949 {
    static Function<String, Integer> stoi = Integer::parseInt;
    static int[][] connected;
    static int[] pop;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi.apply(br.readLine());
        connected = new int[N + 1][N + 1];
        pop = new int[N + 1];

        String[] split = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            pop[i] = stoi.apply(split[i - 1]);
        }

        for (int i = 1; i < N; i++) {
            split = br.readLine().split(" ");
            int v1 = stoi.apply(split[0]);
            int v2 = stoi.apply(split[1]);
            connected[v1][v2] = connected[v2][v1] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(connected[i][j]);
            }
            System.out.println();
        }
    }
}
