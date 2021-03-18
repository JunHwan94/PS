package baekjoon

import java.util.*
import kotlin.math.max

private var M = 0
private var N = 0
private var H = 0
private lateinit var tomatoes: Array<Array<IntArray>>
private lateinit var visited: Array<Array<BooleanArray>>
fun main() {
    with(System.`in`.bufferedReader()) {
        readLine().split(" ").also{
            M = it[0].toInt()
            N = it[1].toInt()
            H = it[2].toInt()
        }
        tomatoes = Array(H){ Array(N){ IntArray(M) } }
        visited = Array(H){ Array(N){ BooleanArray(M) } }
        // 토마토 박스 입력
        for (i in 0 until H){
            for(j in 0 until N){
                val input = readLine().split(" ")
                for(k in 0 until M){
                    tomatoes[i][j][k] = input[k].toInt()
                    if(tomatoes[i][j][k] == 1) {
                        visited[i][j][k] = true
                        q.offer(intArrayOf(i, j, k))
                    }
                }
            }
        }
    }
    if(q.size == M * N * H) {
        println(0)
        return
    }
    bfs()
    tomatoes.forEach{ h->
        h.forEach{ n ->
            n.forEach{ m ->
                if(m == 0) {
                    println(-1)
                    return
                }
            }
        }
    }
    println(max - 1)
}

// 3차원 dx dy dz
val dx = arrayOf(0, 0, 0, 0, 1, -1)
val dy = arrayOf(0, 0, 1, -1, 0, 0)
val dz = arrayOf(1, -1, 0, 0, 0, 0)
val q = LinkedList<IntArray>()
var max = 0
fun bfs() {
    // 방문체크
    while (q.isNotEmpty()) {
        // 6방 탐색
        val x = q.peek()[2]
        val y = q.peek()[1]
        val z = q.poll()[0]
        for(i in 0 until 6){
            val nx = x + dx[i]
            val ny = y + dy[i]
            val nz = z + dz[i]
            if(nx < 0 || nx >= M || ny < 0 || ny >= N || nz < 0 || nz >= H) continue
            if(visited[nz][ny][nx]) continue
            // 0일때만 가기
            if(tomatoes[nz][ny][nx] == 0){
                visited[nz][ny][nx] = true
                q.offer(intArrayOf(nz, ny, nx))
                // 1증가
                tomatoes[nz][ny][nx] = tomatoes[z][y][x] + 1
                max = max(max, tomatoes[nz][ny][nx])
            }
        }
    }
}
