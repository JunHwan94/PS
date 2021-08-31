package baekjoon.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class P5373 {
    static Function<String, Integer> stoi = Integer::parseInt;
    static char[][] cube;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi.apply(br.readLine());

        cube = new char[9][12];
        cube[0] = new char[]{' ', ' ', ' ', 'w', 'w', 'w', ' ', ' ', ' ', ' ', ' ', ' '};
        System.arraycopy(cube[0], 0, cube[1], 0, cube[0].length);
        System.arraycopy(cube[0], 0, cube[2], 0, cube[0].length);
        cube[3] = new char[]{'g', 'g', 'g', 'r', 'r', 'r', 'b', 'b', 'b', 'o', 'o', 'o'};
        System.arraycopy(cube[3], 0, cube[4], 0, cube[3].length);
        System.arraycopy(cube[3], 0, cube[5], 0, cube[3].length);
        cube[6] = new char[]{' ', ' ', ' ', 'y', 'y', 'y', ' ', ' ', ' ', ' ', ' ', ' '};
        System.arraycopy(cube[6], 0, cube[7], 0, cube[3].length);
        System.arraycopy(cube[6], 0, cube[8], 0, cube[3].length);

        for (int i = 0; i < n; i++) {
            char[][] tCube = new char[9][12];
            for (int j = 0; j < 9; j++) {
                System.arraycopy(cube[j], 0, tCube[j], 0, cube[j].length);
            }

            int cnt = stoi.apply(br.readLine());
            String[] dirs = br.readLine().split(" ");

            for (String dir : dirs) {
                char rDir = dir.charAt(1);
                switch (dir.charAt(0)) {
                    case 'U':
                        up(tCube, rDir);
                        break;
                    case 'D':
                        down(tCube, rDir);
                        break;
                    case 'F':
                        front(tCube, rDir);
                        break;
                    case 'B':
                        back(tCube, rDir);
                        break;
                    case 'L':
                        left(tCube, rDir);
                        break;
                    case 'R':
                        right(tCube, rDir);
                        break;
                }
            }

            for (int j = 0; j < 3; j++) {
                System.out.print(tCube[j][3]);
                System.out.print(tCube[j][4]);
                System.out.print(tCube[j][5]);
                System.out.println();
            }
//            System.out.println(tCube[0][3] + "" + tCube[0][4] + "" + tCube[0][5]);
//            System.out.println(tCube[1][3] + "" + tCube[1][4] + "" +  tCube[1][5]);
//            System.out.println(tCube[2][3] + "" + tCube[2][4] + "" + tCube[2][5]);

            Arrays.stream(tCube).forEach(it -> System.out.println(Arrays.toString(it)));
        }
    }

    public static void front(char[][] tCube, char dir){
        int cnt = 1;
        if(dir == '-') cnt = 3;
        for (int i = 0; i < cnt; i++) {
            char t1 = tCube[2][3];
            char t2 = tCube[2][4];
            char t3 = tCube[2][5];
            tCube[2][3] = tCube[5][2];
            tCube[2][4] = tCube[4][2];
            tCube[2][5] = tCube[3][2];
            tCube[5][2] = tCube[6][5];
            tCube[4][2] = tCube[6][4];
            tCube[3][2] = tCube[6][3];
            tCube[6][5] = tCube[3][6];
            tCube[6][4] = tCube[4][6];
            tCube[6][3] = tCube[5][6];
            tCube[3][6] = t1;
            tCube[4][6] = t2;
            tCube[5][6] = t3;
        }

        rotate(tCube, 4, 4, dir);
    }

    public static void back(char[][] tCube, char dir){
        int cnt = 1;
        if(dir == '-') cnt = 3;
        for (int i = 0; i < cnt; i++) {
            char t1 = tCube[0][3];
            char t2 = tCube[0][4];
            char t3 = tCube[0][5];
            tCube[0][3] = tCube[3][8];
            tCube[0][4] = tCube[4][8];
            tCube[0][5] = tCube[5][8];
            tCube[3][8] = tCube[8][3];
            tCube[4][8] = tCube[8][4];
            tCube[5][8] = tCube[8][5];
            tCube[8][3] = tCube[3][0];
            tCube[8][4] = tCube[4][0];
            tCube[8][5] = tCube[5][0];
            tCube[3][0] = t1;
            tCube[4][0] = t2;
            tCube[5][0] = t3;
        }

        rotate(tCube, 10, 4, dir);
    }

    public static void left(char[][] tCube, char dir){
        int cnt = 1;
        if(dir == '-') cnt = 3;
        for (int i = 0; i < cnt; i++) {
            char t1 = tCube[0][3];
            char t2 = tCube[1][3];
            char t3 = tCube[2][3];
            tCube[0][3] = tCube[5][11];
            tCube[1][3] = tCube[4][11];
            tCube[2][3] = tCube[3][11];
            tCube[5][11] = tCube[6][3];
            tCube[4][11] = tCube[7][3];
            tCube[3][11] = tCube[8][3];
            tCube[6][3] = tCube[3][3];
            tCube[7][3] = tCube[4][3];
            tCube[8][3] = tCube[5][3];
            tCube[3][3] = t1;
            tCube[4][3] = t2;
            tCube[5][3] = t3;
        }

        rotate(tCube, 1, 4, dir);
    }

    public static void right(char[][] tCube, char dir){
        int cnt = 3;
        if(dir == '-') cnt = 1;
        for (int i = 0; i < cnt; i++) {
            char t1 = tCube[0][5];
            char t2 = tCube[1][5];
            char t3 = tCube[2][5];
            tCube[0][5] = tCube[5][9];
            tCube[1][5] = tCube[4][9];
            tCube[2][5] = tCube[3][9];
            tCube[5][9] = tCube[6][5];
            tCube[4][9] = tCube[7][5];
            tCube[3][9] = tCube[8][5];
            tCube[6][5] = tCube[3][5];
            tCube[7][5] = tCube[4][5];
            tCube[8][5] = tCube[5][5];
            tCube[3][5] = t1;
            tCube[4][5] = t2;
            tCube[5][5] = t3;
        }

        rotate(tCube, 7, 4, dir);
    }

    public static void up(char[][] tCube, char dir){
        int cnt = 3;
        if(dir == '-') cnt = 1;
        for (int i = 0; i < cnt; i++) {
            char t1 = tCube[3][0];
            char t2 = tCube[3][1];
            char t3 = tCube[3][2];
            tCube[3][0] = tCube[3][9];
            tCube[3][1] = tCube[3][10];
            tCube[3][2] = tCube[3][11];
            tCube[3][9] = tCube[3][6];
            tCube[3][10] = tCube[3][7];
            tCube[3][11] = tCube[3][8];
            tCube[3][6] = tCube[3][3];
            tCube[3][7] = tCube[3][4];
            tCube[3][8] = tCube[3][5];
            tCube[3][3] = t1;
            tCube[3][4] = t2;
            tCube[3][5] = t3;
        }

        rotate(tCube, 4, 1, dir);
    }

    public static void down(char[][] tCube, char dir){
        int cnt = 1;
        if(dir == '-') cnt = 3;
        for (int i = 0; i < cnt; i++) {
            char t1 = tCube[5][0];
            char t2 = tCube[5][1];
            char t3 = tCube[5][2];
            tCube[5][0] = tCube[5][9];
            tCube[5][1] = tCube[5][10];
            tCube[5][2] = tCube[5][11];
            tCube[5][9] = tCube[5][6];
            tCube[5][10] = tCube[5][7];
            tCube[5][11] = tCube[5][8];
            tCube[5][6] = tCube[5][3];
            tCube[5][7] = tCube[5][4];
            tCube[5][8] = tCube[5][5];
            tCube[5][3] = t1;
            tCube[5][4] = t2;
            tCube[5][5] = t3;
        }

        rotate(tCube, 4, 7, dir);
    }

    public static void rotate(char[][] tCube, int x, int y, char dir){
        char[] first = new char[]{tCube[y + 1][x - 1], tCube[y][x - 1], tCube[y - 1][x - 1]};
        char[] second = new char[]{tCube[y + 1][x], tCube[y][x], tCube[y - 1][x]};
        char[] third = new char[]{tCube[y + 1][x + 1], tCube[y][x + 1], tCube[y - 1][x + 1]};
        if(dir == '-'){
            first = new char[]{tCube[y - 1][x + 1], tCube[y][x + 1], tCube[y + 1][x + 1]};
            second = new char[]{tCube[y - 1][x], tCube[y][x], tCube[y + 1][x]};
            third = new char[]{tCube[y - 1][x - 1], tCube[y][x - 1], tCube[y + 1][x - 1]};
        }
        tCube[y - 1][x - 1] = first[0];
        tCube[y - 1][x] = first[1];
        tCube[y - 1][x + 1] = first[2];
        tCube[y][x - 1] = second[0];
        tCube[y][x + 1] = second[2];
        tCube[y + 1][x - 1] = third[0];
        tCube[y + 1][x] = third[1];
        tCube[y + 1][x + 1] = third[2];
    }
}
//2
//3
//U+ U+ F+
//3
//U+ U+ F-
//1
//2
//F+ U+
//1
//4
//D- L+ U- L-
//1
//5
//U- D+ R+ U+ R-
//2
//4
//F+ F+ F- F-
//1
//D-
//1
//16
//U+ R+ R+ F+ F+ R+ R+ U+ F+ F+ R+ R+ F+ F+ U- L+
//1
//5
//L- F+ L+ D+ B+
//1
//4
//U+ D+ F- F-