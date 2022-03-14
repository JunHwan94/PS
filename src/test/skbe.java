package test;

public class skbe {
    public static void main(String[] args) {
        System.out.println(solution(4578, new int[]{1, 4, 99, 35, 50, 1000}));
        System.out.println(solution(1999, new int[]{2, 11, 20, 100, 200, 600}));
    }

    static int[] values = {1, 5, 10, 50, 100, 500};
    static int solution(int money, int[] costs){
        Queue<Coin> pq = new PriorityQueue<>();
        for (int i = 0; i < 6; i++) {
            coins[i] = new Coin(values[i], costs[i]);
        }

        int cost = 0;
        while(!pq.isEmpty()){
            Coin coin = pq.poll();
            int share = money / coin.val;
            money %= coin.val;
            cost += share * coin.cost;
        }

        return cost;
    }

    static class Coin implements Comparable<Coin>{
        int val, cost;
        double pivot;

        Coin(int val, int cost){
            this.val = val;
            this.cost = cost;
            this.pivot = (double)val / cost;
        }
        
        @Override
        public int compareTo(Coin o){
            return pivot == o.pivot ? o.val - val : Double.compare(o.pivot, pivot);
        }
    }
}
