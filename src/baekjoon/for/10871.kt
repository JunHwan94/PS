package baekjoon.`for`

import java.io.*
import java.util.*

// X보다 작은 수
fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    var token = StringTokenizer(br.readLine())
    val stoi: (String) -> Int = { Integer.parseInt(it) }
    val p = Pair(stoi(token.nextToken()), stoi(token.nextToken()))
    val sb = StringBuffer()
    token = StringTokenizer(br.readLine())
    repeat(p.first){
        val input = stoi(token.nextToken())
        if(input < p.second)
            sb.append("$input ")
    }
    BufferedWriter(OutputStreamWriter(System.`out`)).run{
        write(sb.toString())
        flush()
        close()
    }
    br.close()
}