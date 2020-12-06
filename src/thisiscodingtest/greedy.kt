package thisiscodingtest

import java.util.*

fun main(){
    val sc = Scanner(System.`in`)

    // 거스름돈
//    val coins = sc.nextInt()
//    val cnt = processCoins(coins)
//    println("${cnt}개")

    // 1이 될 때까지
//    val n = sc.nextInt()
//    val k = sc.nextInt()
//    val cnt = processUntilOne(n, k)
//    println("연산 ${cnt}번 수행")

    // 곱하기 혹은 더하기
//    val s = sc.nextLine()
//    val mp = processMulOrPlus(s)
//    println(mp)

    val n = sc.nextInt()
    val arr = IntArray(n){ sc.nextInt() }
    val gCnt = guild(arr)
    println(gCnt)
}

// 거스름돈
fun processCoins(n: Int): Int{
    var coins = n
    var cnt = 0
    val coinTypes = intArrayOf(500, 100, 50, 10)
    for(ct in coinTypes){
        cnt += coins / ct
        coins %= ct
    }
    return cnt
}

// 1이 될 때까지
fun processUntilOne(N: Int, k: Int): Int{
    var n = N
    var cnt = 0
    var target: Int
    while(true){
        // n이 k로 나누어 떨어지는 수가 될 때까지 빼기
        target = (n / k) * k // n보다 작은 수 중 k로 나누어 떨어지는 가장 가까운 수 찾기
        cnt += n - target // n에서 target값을 빼서 1을 빼는 횟수를 한번에 더함
        n = target
        //
        if(n < k) break
        cnt++
        n /= k
    }
    cnt += n - 1
    return cnt
} // logN 시간복잡도를 가짐

// 곱하기 혹은 더하기
fun processMulOrPlus(s: String) =
        s.fold(1){ acc, next ->
            val ni = next - '0'
            when (ni) {
                0, 1 -> acc + ni
                else -> acc * ni
            }
        }

// 모험가 길드
fun guild(arr: IntArray): Int{
    var result = 0
    var count = 0
    val pq = PriorityQueue<Int>(arr.size)
    arr.forEach{ i -> pq.offer(i) }

    while(pq.isNotEmpty()){
        count += 1
        if(count >= pq.poll()){
            result += 1
            count = 0
        }
    }
    return result
}