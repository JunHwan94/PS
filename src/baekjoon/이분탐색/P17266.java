import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17266 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = stoi(br.readLine());
        int M = stoi(br.readLine());

        int[] lights = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            lights[i] = stoi(st.nextToken());
        }

        int left = 0, right = 100000;
        while(left + 1 < right){
            int mid = (left + right) / 2;
            boolean passable = true;

            for(int i = 0; i < M - 1; i++){
                // 가로등 사이 거리가 높이*2 보다 크면 안됨
                if(lights[i + 1] - lights[i] > mid * 2){
                    passable = false;
                    break;
                }
            }

            // 끝에 있는 가로등이 끝까지 못비추면 안됨
            if(lights[0] > mid || N - lights[M - 1] > mid){
                passable = false;
            }

            // mid 높이로 전체 비추기 가능하면 줄이기
            if(!passable){
                left = mid;
            }else{ // 불가능하면 늘리기
                right = mid;
            }
        }

        System.out.println(right);
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
