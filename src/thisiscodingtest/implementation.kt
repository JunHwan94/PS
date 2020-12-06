package thisiscodingtest
import java.util.Scanner
import java.util.PriorityQueue
// 구현 문제
private fun main(){
    val sc = Scanner(System.`in`)

    // 상하좌우
//    val n = sc.nextLine().toInt()
//    val cmd = sc.nextLine()
//    val dest = lrud(n, cmd)
//    println("${dest[0]} ${dest[1]}")

    // 시각 문제
//    println(countThree(sc.nextLine().toInt()))

    // 왕실의 나이트
//    println(countKnightLocation(sc.nextLine()))
//    println(countKnightSteps(sc.nextLine()))

    // 문자열 재정렬
    println(resortString(sc.nextLine()))
}

// 상하좌우
fun lrud(n: Int, cmd: String): IntArray{
    return cmd.fold(intArrayOf(1,1)){ acc, next ->
        when(next) {
            'L' -> if (acc[1] > 1) acc[1]--
            'R' -> if (acc[1] < n) acc[1]++
            'U' -> if (acc[0] > 1) acc[0]--
            'D' -> if (acc[0] < n) acc[0]++
        }
        acc
    }
}

// 시각 문제 - ~시~분~초 ~에 3이 포함되는 시각의 수
fun countThree(n: Int): Int{
    var count = 0
    for(i in 0..n){
        for(j in 0..59){
            for(k in 0..59){
                if("$i$j$k".contains("3")) count++
            }
        }
    }
    return count
}

// 왕실의 나이트
fun countKnightLocation(s: String): Int{
    var count = 0
    // 왼쪽
    if(s[0] - 2 >= 'a'){
        if(s[1] - '0' - 1 > 0) count++
        if(s[1] - '0' + 1 <= 8) count++
    }
    // 오른쪽
    if(s[0] - 2 <= 'h'){
        if(s[1] - '0' - 1 > 0) count++
        if(s[1] - '0' + 1 <= 8) count++
    }
    // 위쪽
    if(s[1] - '0' - 2 > 0){
        if(s[0] - 1 >= 'a') count++
        if(s[0] + 1 <= 'h') count++
    }
    // 아래쪽
    if(s[1] - '0' + 2 <= 8){
        if(s[0] - 1 >= 'a') count++
        if(s[0] + 1 <= 'h') count++
    }
    return count
}
fun countKnightSteps(s: String): Int{
    val row = s[1] - '0'
    val col = (s[0] - 'a') + 1
    val steps = arrayOf(arrayOf(-2, -1), arrayOf(-2, 1), arrayOf(2, -1), arrayOf(2, 1),
            arrayOf(-1, -2), arrayOf(-1, 2), arrayOf(1, -2), arrayOf(1, 2))
    var result = 0
    for(step in steps){
        val nextRow = row + step[0]
        val nextCol = col + step[1]
        if(nextRow in 1..8 && nextCol in 1..8) result++
    }
    return result
}

// 문자열 재정렬
fun resortString(s: String): String{
    var result = ""
    val apq = PriorityQueue<Char>()
    var sum = 0

    s.forEach{
        if(it in 'A'..'Z') apq.offer(it)
        else sum += it - '0'
    }

    while(apq.isNotEmpty())
        result += apq.poll()

    return result + sum
}