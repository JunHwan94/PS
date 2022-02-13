package baekjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P5430 {
    static final int FORWARD = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = stoi(br.readLine());

        for (int t = 0; t < T; t++) {
            String ops = br.readLine();
            br.readLine();
            Deque<Integer> d = new ArrayDeque<>();

            StringBuilder arrSb = new StringBuilder(br.readLine());
            arrSb.deleteCharAt(0);
            arrSb.deleteCharAt(arrSb.length() - 1);
            StringTokenizer st = new StringTokenizer(arrSb.toString(), ",");
            while(st.hasMoreTokens()){
                d.offerLast(stoi(st.nextToken()));
            }

            int dir = FORWARD;
            boolean errorOccurred = false;
            for (int i = 0; i < ops.length(); i++) {
                if(ops.charAt(i) == 'R'){
                    dir = (dir + 1) % 2;
                }else{
                    if(d.isEmpty()){
                        System.out.println("error");
                        errorOccurred = true;
                        break;
                    }
                    if(dir == FORWARD){
                        d.pollFirst();
                    }else{
                        d.pollLast();
                    }
                }
            }
            if(errorOccurred){
                continue;
            }

            StringBuilder sb = new StringBuilder();
            sb.append('[');
            if(!d.isEmpty()) {
                append(sb, d, dir);
            }
            sb.append(']');
            System.out.println(sb);
        }
    }

    static void append(StringBuilder sb, Deque<Integer> d, int dir){
        if(dir == FORWARD) {
            while (!d.isEmpty()) {
                sb.append(d.pollFirst()).append(',');
            }
        }else{
            while (!d.isEmpty()) {
                sb.append(d.pollLast()).append(',');
            }
        }
        sb.deleteCharAt(sb.length() - 1);
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
