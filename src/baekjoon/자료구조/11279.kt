package baekjoon.우선순위큐

import java.io.*
import java.util.*

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    BufferedWriter(OutputStreamWriter(System.out)).run {
        val n = Integer.parseInt(br.readLine())
        val pq = PriorityQueue<Int>(Collections.reverseOrder())
        repeat(n) {
            val i= Integer.parseInt(br.readLine())
            when {
                i == 0 && pq.isNotEmpty() -> write("${pq.poll()}\n")
                i == 0 && pq.isEmpty() -> write("0\n")
                else -> pq.offer(i)
            }
        }
        flush()
        close()
        br.close()
    }
}