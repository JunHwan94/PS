package baekjoon.BFS

import java.util.*

class P2206 {
}

lateinit var map: Array<CharArray>
lateinit var visited: Array<BooleanArray>
var N = 0
var M = 0
fun main(){
    with(System.`in`.bufferedReader()){
        val input = readLine().split(" ")
        N = input[0].toInt()
        M = input[1].toInt()
        map = Array(N){ CharArray(M) }
        for(i in 0 until N){
            map[i] = readLine().toCharArray()
        }
        visited = Array(N){ BooleanArray(M) }
        visited[0][0] = true
    }
    val q = LinkedList<Pair<Int, Int>>()
    q.offer(Pair(0, 0))
    bfs(q, true)
    val res = map[N - 1][M - 1]
    println(if(res == '0') -1 else max - '0' + 2)
//    map.forEach { println(Arrays.toString(it)) }
}
// bfs
val dx = arrayOf(1, 0, -1 ,0)
val dy = arrayOf(0, 1, 0, -1)
var max = '0'
fun bfs(q: LinkedList<Pair<Int, Int>>, haveOpp: Boolean){
    while(q.isNotEmpty()){
        val loc = q.poll()
        val x = loc.first
        val y = loc.second
        for(i in 0 until 4){
            val nx = x + dx[i]
            val ny = y + dy[i]
            if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue
            if(visited[ny][nx]) continue
            if(map[ny][nx] == '1'){
                // 기회 남았으면 부분집합으로
                if(haveOpp) supSet(q, Pair(nx, ny))
                // 안남았으면 return
                else return
                    //return
            }
            if(map[ny][nx] != '1'){
                visited[ny][nx] = true
                q.offer(Pair(nx, ny))
                map[ny][nx] = map[y][x] + 1
            }
        }
    }
    max = map[N - 1][M - 1]
}

fun supSet(q: LinkedList<Pair<Int, Int>>, p: Pair<Int, Int>){
    visited[p.second][p.first] = true
    q.offer(Pair(p.first, p.second))
    // 여기서 벽 허물기, 안허물기 bfs호출
    map[p.second][p.first] = '0'
    bfs(q, false)

    visited[p.second][p.first] = false
    q.poll()
    map[p.second][p.first] = '1'
    bfs(q, true)
}