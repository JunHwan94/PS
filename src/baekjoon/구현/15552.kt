package baekjoon.`for`
import java.io.*
import java.util.*

// 빠른 A+B
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val n = Integer.parseInt(br.readLine())
    val token: (String) -> StringTokenizer = { StringTokenizer(it) }
    val input: (StringTokenizer) -> Int = { Integer.parseInt(it.nextToken()) + Integer.parseInt(it.nextToken()) }
    repeat(n){
        bw.write("${input(token(br.readLine()))}")
        bw.newLine()
    }
    br.close()
    bw.flush()
    bw.close()
}