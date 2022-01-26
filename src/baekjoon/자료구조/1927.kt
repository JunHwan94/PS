package baekjoon.우선순위큐

import java.util.*

fun main(){
    val br = System.`in`.bufferedReader()
    System.out.bufferedWriter().run {
        val n = Integer.parseInt(br.readLine())
        val pq = PriorityQueue<Int>()
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