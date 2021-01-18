package baekjoon.순열.P15649

import java.util.*
// n과 m (1)
const val MAX = 9
val bArr = BooleanArray(MAX)
var n = 0
var m = 0
var arr = Array(MAX){ 0 }
fun main(){
    StringTokenizer(readLine()).run {
        n = Integer.parseInt(nextToken())
        m = Integer.parseInt(nextToken())
        permutation(0)
    }
}

fun permutation(cnt: Int){
    if (cnt == m) {
        System.out.bufferedWriter().run {
            for (i in 0 until m) {
                write("${arr[i]} ")
            }
            write("\n")
            flush()
        }
        return
    }

    for (i in 1..n){
        if(!bArr[i]){
            bArr[i] = true
            arr[cnt] = i
            permutation(cnt + 1)
            bArr[i] = false
        }
    }
}