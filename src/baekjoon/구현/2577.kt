package baekjoon.`1차원배열`

// 나머지 Set 사용함
fun main(){
    val br = System.`in`.bufferedReader()
    val stoi: (String) -> Int = { Integer.parseInt(it) }
    var mul = 1
    repeat(3){ mul *= stoi(br.readLine()) }
    Array(10){ 0 }.apply{
        while(mul > 0) {
            this[mul % 10]++
            mul /= 10
        }
    }.forEach{
        println(it)
    }
}