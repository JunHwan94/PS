package baekjoon.`1차원배열`

fun main(){
    val br = System.`in`.bufferedReader()
    val n = Integer.parseInt(br.readLine())
    var sum = 0
    var score = 0
    repeat(n){
        val ox = br.readLine()
        ox.forEach{
            if(it == 'O'){
                score++
                sum += score
            }else{
                score = 0
            }
        }
        println(sum)
        score = 0
        sum = 0
    }
}