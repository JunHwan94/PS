package baekjoon.`1차원배열`

import java.util.*

fun main(){
//    val br = System.`in`.bufferedReader()
//    val n = Integer.parseInt(br.readLine())
//    val token = StringTokenizer(br.readLine())
//    var max = 0
//    println(
//            Array(n){ Integer.parseInt(token.nextToken()) }.also{
//                it.forEach{ i ->
//                    if(max < i) max = i
//                }
//            }.map{
//                it.toDouble() / max * 100
//            }.average()
//    )

    readLine()
    readLine()!!.split(" ").map{it.toInt()}.run{
        print(average()*100/max()!!)
    }

//    with(BufferedReader(InputStreamReader(System.`in`))) {
//        val n = readLine().toInt()
//        var st = StringTokenizer(readLine())
//        var value:Float = 0f
//        var max:Int = 0
//        for(i in 0 until n){
//            val a = st.nextToken().toInt()
//            value += a
//            if(a > max){
//                max = a
//            }
//        }
//        print(value / (max * n) * 100)
//    }
}