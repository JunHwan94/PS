package baekjoon.문자열

fun main(){
    val arr = Array(26){ 0 }
    System.`in`.bufferedReader().readLine().onEach { c ->
        arr[c.uppercaseChar() - 'A']++
    }
    var idx = 0
    var max = 0
    for(i in arr.indices){
        if(max < arr[i]){
            idx = i
            max = arr[i]
        }
    }
    var maxCnt = 0
    for(i in arr.indices){
        if(max == arr[i]){
            maxCnt++
        }
    }
    if(maxCnt > 1){
        println("?")
    }else println((idx + 'A'.code).toChar())
}