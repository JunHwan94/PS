package baekjoon.`for`

import java.io.*

private fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = Integer.parseInt(br.readLine())
    generateSequence(1) { it + 1 }.take(9).forEach {
        println("$n * $it = ${n * it}")
    }
}