package baekjoon.`1차원배열`

fun main(){
    val br = System.`in`.bufferedReader()
    val set = hashSetOf<Int>()
    repeat(10){
        val i = Integer.parseInt(br.readLine())
        set.add(i % 42)
    }
    println(set.size)
}