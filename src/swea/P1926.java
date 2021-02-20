package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i = 1; i <= N; i++){
            char[] ca = String.valueOf(i).toCharArray();
            StringBuilder tsb = new StringBuilder();
            for(int j = 0; j < ca.length; j++){
                int num = ca[j] - '0';
                // - 포함안하고 369일 때
                if(tsb.indexOf("-") == -1 && num != 0 && num % 3 == 0) {
                    tsb.delete(0, sb.length()); // 다지우고
                    tsb.append('-'); // - 추가
                }
                // - 포함하고 369일 때
                else if(tsb.indexOf("-") != -1 && num != 0 && num % 3 == 0){
                    tsb.append('-'); // - 추가
                }
                // - 포함하고 369아닐 때
                else if(tsb.indexOf("-") != -1 && num % 3 != 0) continue;
                else if(tsb.indexOf("-") != -1 && num == 0) continue;
                else tsb.append(num);
            }
            sb.append(tsb).append(' ');
        }
        System.out.println(sb);
    }
}
