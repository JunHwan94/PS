package baekjoon.`for`

import java.io.*

// 별 찍기 - 2
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = Integer.parseInt(br.readLine())
    StringBuffer().apply {
        for (i in 1..n) {
            repeat(n - i) { append(" ") }
            repeat(i) { append("*") }
            append("\n")
        }
    }.also {
        print(it)
    }
}