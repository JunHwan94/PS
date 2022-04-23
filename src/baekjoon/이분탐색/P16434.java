package baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16434 {
    static class GameObject{
        int type;
        long atk, hp;
        public GameObject(int type, long atk, long hp){
            this.type = type;
            this.atk = atk;
            this.hp = hp;
        }
    }

    static int N;
    static long hAtk;
    static GameObject[] gameObjects;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = stoi(st.nextToken());
        hAtk = stoi(st.nextToken());
        gameObjects = new GameObject[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = stoi(st.nextToken());
            long a = stoi(st.nextToken());
            long h = stoi(st.nextToken());
            gameObjects[i] = new GameObject(t, a, h);
        }

        long minHp = binarySearch();

        System.out.println(minHp);
    }

    static long binarySearch(){
        long left = 0;
        long right = Long.MAX_VALUE - 1000000;
        long mid;
        while(left < right){
            mid = (left + right) / 2;
            if(!canClear(mid)){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        return left;
    }

    static boolean canClear(long hp){
        long maxHp = hp;
        long atk = hAtk;
        long min = Long.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            long rhp;
            if(gameObjects[i].type == 1){
                long hitCnt = gameObjects[i].hp / atk;
                if(gameObjects[i].hp % atk == 0){
                    hitCnt -= 1;
                }
                rhp = hitCnt * gameObjects[i].atk;
                min = Math.min(min, rhp);
                hp -= rhp;
                if(hp <= 0){
                    return false;
                }
            }else{
                atk += gameObjects[i].atk;
                hp += gameObjects[i].hp;
                if(hp > maxHp){
                    hp = maxHp;
                }
            }
        }
        return true;
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}