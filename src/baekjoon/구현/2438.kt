package baekjoon.`for`

import java.io.*

// 별 찍기 - 1
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    BufferedWriter(OutputStreamWriter(System.`out`)).run {
        (1..n).forEach {
            repeat(it){ write("*") }
            newLine()
        }
        flush()
        close()
    }
    br.close()
}