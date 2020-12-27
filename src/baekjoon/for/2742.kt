package baekjoon.`for`

import java.io.*

// 기찍 N
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = Integer.parseInt(br.readLine())
    BufferedWriter(OutputStreamWriter(System.`out`)).run{
        (n downTo 1).forEach{
            write("$it")
            newLine()
        }
        flush()
        close()
    }
    br.close()
}