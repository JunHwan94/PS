package test;

public class skbe {
    public static void main(String[] args) {
        System.out.println(solution(4578, new int[]{1, 4, 99, 35, 50, 1000}));
        System.out.println(solution(1999, new int[]{2, 11, 20, 100, 200, 600}));
    }

    static int[] values = {1, 5, 10, 50, 100, 500};
    static int[] arr;
    static Coin[] coins;
    static int solution(int money, int[] costs){
        coins = new Coin[6];
        for (int i = 0; i < 6; i++) {
            coins[i] = new Coin(values[i], costs[i]);
        }

        arr = new int[6];
        selected = new boolean[6];
        minCost = 1000000000;
        perm(0, money);

        return minCost;
    }

    static boolean[] selected;
    static int minCost;
    static void perm(int n, int money){
        if(n == 6){
            // 앞에꺼부터 최대한 많은 개수로 생산비용 계산
            int totalCost = 0;
            for (int i = 0; i < arr.length; i++) {
                while(money >= coins[arr[i]].val){
                    // 가치 값 감소
                    money -= coins[arr[i]].val;
                    // 생산 비용 증가
                    totalCost += coins[arr[i]].cost;
                }
            }
//            System.out.println(totalCost);
            minCost = Math.min(minCost, totalCost);
            return;
        }

        for (int i = 0; i < 6; i++) {
            if(selected[i]) {
                continue;
            }
            selected[i] = true;
            arr[n] = i;
            perm(n + 1, money);
            selected[i] = false;
        }
    }

    static class Coin{
        int val, cost;

        Coin(int val, int cost){
            this.val = val;
            this.cost = cost;
        }
    }
}
