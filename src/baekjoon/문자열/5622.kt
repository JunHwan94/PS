package baekjoon.문자열

fun main(){
    println(readLine()!!.fold(0){ acc, next -> acc + charToNum(next)})
}

fun charToNum(c: Char): Int{
    val result = (c - 'A') / 3 + 3
    return if(c == 'S' || c == 'V' || c == 'Y' || c == 'Z') result - 1
        else result
}