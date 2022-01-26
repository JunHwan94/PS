package baekjoon.`1차원배열`

// 최댓값
fun main(){
    val br = System.`in`.bufferedReader()
    var max = 1
    var index = 0
    for(i in 1..9){
        val input = Integer.parseInt(br.readLine())
        if(input > max) {
            max = input
            index = i
        }
    }
    print("$max\n$index")
}