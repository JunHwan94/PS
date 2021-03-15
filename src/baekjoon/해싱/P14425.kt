package baekjoon

var N = 0
var M = 0
fun main(){
    val br = System.`in`.bufferedReader()
    val nm = br.readLine().split(" ")
    N = nm[0].toInt()
    M = nm[1].toInt()
    var cnt = 0
    HashSet<String>().apply{
        for(i in 0 until N)
            add(br.readLine())
    }.also{
        for(i in 0 until M)
            if(it.contains(br.readLine())) cnt++
    }
    println(cnt)
}