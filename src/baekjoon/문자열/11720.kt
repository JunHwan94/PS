package baekjoon.문자열

fun main(){
    with(System.`in`.bufferedReader()){
        readLine()
        readLine().map {
            it.code - 48
        }.fold(0){ acc, next ->
            acc + next
        }.also{
            println(it)
        }
    }
}