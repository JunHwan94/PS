package baekjoon.FloydWarshall

import java.util.*

lateinit var routes: Array<IntArray>
lateinit var deque: Deque<Int>
fun main(){
    val n = readLine()!!.toInt()
    val m = readLine()!!.toInt()
    val INF = 100_000_000
    val dist = Array(n + 1){ i -> IntArray(n + 1){ j -> if(i == j) 0 else INF } }
    repeat(m){
        val input = readLine()!!.split(" ")
        val from = input[0].toInt()
        val to = input[1].toInt()
        val d = input[2].toInt()
        dist[from][to] = dist[from][to].coerceAtMost(d)
    }

//    val routes = Array(n + 1){ Array(n + 1) { Stack<Int>() } }//IntArray(n + 1) } }
    routes = Array(n + 1){ IntArray(n + 1) }
    for (k in 1 .. n){
        for (i in 1 .. n){
            if(i == k) continue
            for(j in 1 .. n){
                if(i == j || k == j) continue
                if(dist[i][j] > dist[i][k] + dist[k][j]){
//                    println("$i $k $j")
                    dist[i][j] = dist[i][k] + dist[k][j]
//                    routes[i][j].push(k)
                    routes[i][j] = k
                }
            }
        }
    }

    for(i in 1 until dist.size) {
        for(j in 1 until dist.size){
            print(if (dist[i][j] == INF) 0 else dist[i][j])
            print(" ")
        }
        println()
    }

    deque = ArrayDeque()
    for(i in 1 .. n) {
        for(j in 1 .. n){
//            print("$i 에서 $j 로")
            if(dist[i][j] == INF || dist[i][j] == 0) println(0)
            else{
                deque.clear()
                findRoute(i, j)
                print("${deque.size} ")
                while(deque.isNotEmpty()){
                    print("${deque.poll()} ")
                }
                println()
            }
        }
    }
}

fun findRoute(start: Int, end: Int) {
    if(routes[start][end] == 0){
        deque.offerLast(start)
        deque.offerLast(end)
        return
    }
    findRoute(start, routes[start][end])
    deque.pollLast()
    findRoute(routes[start][end], end)
}
