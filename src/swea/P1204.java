package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1204 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] zTo100 = new int[101];
        for(int t = 1; t <= T; t++){
            br.readLine();
            StringTokenizer token = new StringTokenizer(br.readLine());
            for(int i = 0; i < 1000; i++)
                zTo100[Integer.parseInt(token.nextToken())]++;

            int max = -1;
            int most = -1;
            for(int i = 0; i < 101; i++){
                if(max <= zTo100[i]){
                    max = zTo100[i];
                    most = i;
                }
            }

            System.out.println("#" + t + " " + most);
            for(int i = 0; i < 51; i++){
                zTo100[i] = 0;
                zTo100[100 - i] = 0;
            }
        }
    }
}
