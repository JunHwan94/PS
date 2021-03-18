package baekjoon.BFS

import java.util.*
import kotlin.math.max

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
    }
    val q = LinkedList<Pair<Int, Int>>()
    for(i in 0 until N){
        for(j in 0 until M){
            if(map[i][j] == '1'){
                visited = Array(N){ BooleanArray(M) }
                visited[0][0] = true
                map[i][j] = '0'
                val tMap = Array(map.size){ map[it].copyOf(map[it].size) }
                q.offer(Pair(0, 0))
                bfs(q, tMap)
                map[i][j] = '1'
//                tMap.forEach{ println(it) }
            }
        }
    }
//    val res = map[N - 1][M - 1]
    println(if(max == Char.MAX_VALUE) -1 else max - '0' + 1)
//    map.forEach { println(Arrays.toString(it)) }
}
// bfs
val dx = arrayOf(1, 0, -1 ,0)
val dy = arrayOf(0, 1, 0, -1)
var max = Char.MAX_VALUE
fun bfs(q: LinkedList<Pair<Int, Int>>, tMap: Array<CharArray>){
    while(q.isNotEmpty()){
        val loc = q.poll()
        val x = loc.first
        val y = loc.second
        for(i in 0 until 4){
            val nx = x + dx[i]
            val ny = y + dy[i]
            if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue
            if(visited[ny][nx]) continue

            if(tMap[ny][nx] == '0'){
                visited[ny][nx] = true
                q.offer(Pair(nx, ny))
                tMap[ny][nx] = tMap[y][x] + 1
//                println("${tMap[y][x]}에서 1 더해서 ${tMap[ny][nx]}")
            }
        }
    }
    val last = tMap[N - 1][M - 1]
    if(last > '0')
        max = if(last < max) last else max
}