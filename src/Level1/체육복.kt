package Level1

fun main(){
    println(solution(5, intArrayOf(2, 4), intArrayOf(1, 3, 5)))
    println(solution(5, intArrayOf(2, 4), intArrayOf(3)))
    println(solution(3, intArrayOf(3), intArrayOf(1)))
    println(solution(5, intArrayOf(4, 5), intArrayOf(2, 3)))
    println(solution(5, intArrayOf(3, 4), intArrayOf(2, 5)))
    println(solution(5, intArrayOf(3, 5), intArrayOf(2, 4)))
    println(solution(10, intArrayOf(3, 4, 5), intArrayOf(2, 4, 5)))
}

private fun solution(n: Int, lost: IntArray, reserve: IntArray): Int{
    var answer = n - lost.size
    val lostSet = lost.toSet() - reserve.toSet()
    val reserveSet = (reserve.toSet() - lost.toSet()) as MutableSet

    answer += lost.size - lostSet.size
    for(i in lostSet){
        when{
            i - 1 in reserveSet -> {
                reserveSet.remove(i - 1)
                answer++
            }
            i + 1 in reserveSet -> {
                reserveSet.remove(i + 1)
                answer++
            }
        }
    }
    return answer
}