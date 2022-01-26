package baekjoon.`for`

import java.io.*

// N 찍기
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = Integer.parseInt(br.readLine())
    BufferedWriter(OutputStreamWriter(System.`out`)).run{
        (1..n).forEach{
            write("$it")
            newLine()
        }
        flush()
        close()
    }
    br.close()
}