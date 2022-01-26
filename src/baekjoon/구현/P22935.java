package baekjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class P22935 {
    static Function<String, Integer> stoi = Integer::parseInt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = stoi.apply(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int i = stoi.apply(br.readLine());
            if(i > 28) i = i % 28;
            i = 15 - Math.abs(15 - i);
            if(i == 0) i = 2;
            String s = "VVV" + Integer.toBinaryString(i);
            sb.append(s.substring(s.length() - 4).replace("0", "V").replace("1", "딸기")).append('\n');
        }
        System.out.println(sb);
    }
}
