package baekjoon.완전탐색.DFS;

// 유기농배추
var field = Array(51){ BooleanArray(51) }
var visited = Array(51){ BooleanArray(51) }
var width = 0
var height = 0
fun main(){
    val case = readLine()!!.toInt()
    repeat(case){
        readLine()!!.split(" ").run{
            width = this[0].toInt()
            height = this[1].toInt()
            val cabCnt = this[2].toInt()
            repeat(cabCnt){
                val line = readLine()!!.split(" ")
                field[line[0].toInt()][line[1].toInt()] = true
            }

            var cnt = 0
            for(i in 0 until width){
                for(j in 0 until height){
                    if(field[i][j] && !visited[i][j]) {
                        cnt++
                        dfs(i, j)
                    }
                }
            }
            println(cnt)
            // 밭, 방문 초기화
            field = Array(51){ BooleanArray(51) }
            visited = Array(51){ BooleanArray(51) }
        }
    }
}

// 사방탐색하며 방문 표시
val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun dfs(x: Int, y: Int){
    visited[x][y] = true

    for(i in 0 until 4){
        val nx = x + dx[i]
        val ny = y + dy[i]
        // 다음 인덱스가 밭을 벗어나면 넘어가기
        if(nx < 0 || nx >= width || ny < 0 || ny >= height)
            continue
        // 배추 없거나 방문했으면 넘어가기
        if(!field[nx][ny] || visited[nx][ny])
            continue
        dfs(nx, ny) // 계속 탐색
    }
}