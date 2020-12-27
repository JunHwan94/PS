package baekjoon.함수

fun main(){
    val br = System.`in`.bufferedReader()
    val n = Integer.parseInt(br.readLine())
    var cnt = 99
    if(n < 100) {
        println(n)
    } else {
        for (i in 100..n) {
            if(count(i))
                cnt++
        }
        println(cnt)
    }
}

fun count(n: Int): Boolean{
    var tmp = n
    val arr = Array(n.toString().length){ 0 }.apply{
        for(i in n.toString().indices){
            this[i] = tmp % 10
            tmp /= 10
        }
    }
    val d = arr[0] - arr[1]
    val cnt = arr.asList().zipWithNext().filter{
        it.first - it.second != d
    }.count()
    return cnt == 0
}