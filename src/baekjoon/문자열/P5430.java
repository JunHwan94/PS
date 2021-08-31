package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Function;

public class P5430 {
    static Function<String, Integer> stoi = Integer::parseInt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = stoi.apply(br.readLine());
        for (int i = 0; i < T; i++) {
            String methods = br.readLine();
            int length = stoi.apply(br.readLine());

            Deque<String> deque = new ArrayDeque<>();
            String line = br.readLine();
            line = line.substring(1, line.length() - 1);
            String[] split = line.split(",");

            for (String s : split)
                deque.offerLast(s);

            // 배열 순서대로 : 1, 역순 : -1
            int acc = 1, size = length;
            boolean error = false;
            for (int j = 0; j < methods.length(); j++) {
                if(methods.charAt(j) == 'R'){
                    acc *= -1;
                    continue;
                }
                if(length == 0 || size == 0){
                    error = true;
                    System.out.println("error");
                    break;
                }
                if(acc == 1) deque.pollFirst();
                else deque.pollLast();
                size--;
            }
            if(error) continue;

            StringBuilder sb = new StringBuilder();
            sb.append('[');
            if(acc == 1) {
                while (!deque.isEmpty())
                    sb.append(deque.pollFirst()).append(',');
            }else{
                while(!deque.isEmpty())
                    sb.append(deque.pollLast()).append(',');
            }
            if(sb.length() > 1) sb.deleteCharAt(sb.length() - 1);
            sb.append(']');
            System.out.println(sb);
        }
    }
}
