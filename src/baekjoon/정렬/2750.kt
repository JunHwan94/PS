package baekjoon.정렬

import java.util.*

// 수 정렬하기
fun main(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = Integer.parseInt(br.readLine())
    val sb = StringBuffer()
    PriorityQueue<Int>(n).apply {
        repeat(n) {
            offer(Integer.parseInt(br.readLine()))
        }
    }.also {
        while (it.isNotEmpty()) {
            sb.append("${it.poll()}\n")
        }
        bw.run{
            write(sb.toString())
            flush()
            close()
        }
        br.close()
    }
}