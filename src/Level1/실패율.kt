package Level1

import java.util.*

fun main(){
    solution(5, intArrayOf(2, 1, 2, 6, 2, 4, 3, 3)).forEach{ print(it) }
    println()
    solution(4, intArrayOf(4, 4, 4, 4, 4)).forEach{ print(it) }
    println()
    solution1(5, intArrayOf(2, 1, 2, 6, 2, 4, 3, 3)).forEach{ print(it) }
    println()
    solution1(4, intArrayOf(4, 4, 4, 4, 4)).forEach{ print(it) }
}

fun solution(N: Int, stages: IntArray): IntArray{
    // 실패율 높은 스테이지부터 내림차순 배열
    val map = HashMap<Int, Double>()

    val failRates = ArrayList<Double>()
    for(i in 1 .. N){
        val failRate =
                if(stages.count{ i <= it} != 0) stages.count{ it == i } / stages.count{ i <= it }.toDouble()
                else .0
        if(!failRates.contains(failRate)) failRates.add(failRate)
        map[i] = failRate
        println("$i | $failRate")
    }
    failRates.sort()

    val sameFailRateStageLists = ArrayList<ArrayList<Int>>()
    failRates.forEach{ sameFailRateStageLists.add(arrayListOf()) }

    failRates.withIndex().forEach { iv ->
        map.forEach {
            if (iv.value == it.value){
                sameFailRateStageLists[iv.index].add(it.key)
            }
        }
    }
    return sameFailRateStageLists.reversed().flatten().toIntArray()

    // 실패율 리스트 만들어서 failRates
    // 실패율이 같은 리스트 만들고 sameFailRateStageLists : List<List<Int>>
    // 작은 스테이지 순서로 정렬하고 sameFailRateStages : List<Int>
    // 실패율 큰 리스트 > 작은 리스트 .flatMap()
    // 이어붙이기

    // 실패율 = 스테이지 도달했으나 클리어 못한 수 / 스테이지 도달 수
    // 첫 케이스
    // {    스테이지 5개
    //      도달 수 : 1
    //      클리어 수 : 1
    //      1실패율 : 1/8
    //      2실패율 : 3/7
    //      3실패율 : 2/4
    //      4실패율 : 1/2
    //      5실패율 : 0
    //      3,4,2,1,5
}

fun solution1(N: Int, stages: IntArray): IntArray {
    val answer = IntArray(N){ 0 }
    val pq = PriorityQueue<Stage>()
    for(i in 1 until N + 1){
        var fail = 0
        var reach = 0
        stages.forEach{
            if(it == i) fail++
            if(it >= i) reach++
        }

        pq.add(Stage(i, if(fail == 0 || reach == 0) .0 else fail.toDouble() / reach.toDouble()))
        println("$i | ${fail.toDouble() / reach.toDouble()}")
    }

    for(i in 0 until answer.size){
        answer[i] = pq.poll().level
    }

    return answer
}

data class Stage(val level: Int, val failRate: Double = .0): Comparable<Stage>{
    override fun compareTo(other: Stage): Int {
        return if(failRate == other.failRate) level.compareTo(other.level) // 실패율 같으면 레벨 오름차순
        else other.failRate.compareTo(failRate) // 실패율 내림차순
    }
}

class Solution {
//data class Stage(var level: Int, var pass: Int, var fail: Int) {
//    val failRate: Float
//        get() = if (fail+pass == 0)  0.0f else (fail.toFloat()) / (pass + fail)
//}
//    fun solution(N: Int, stages: IntArray): IntArray {
//        var stageInfo = Array(N,  { Stage(it+1, 0, 0)})
//
//        for (level in stages) {
//            for (i in 0.until(level-1)) {
//                stageInfo[i].pass++
//            }
//            if (level != N+1) stageInfo[level-1].fail++
//        }
//        stageInfo.sortByDescending { it.failRate }
//        return stageInfo.map { it.level }.toIntArray()
//    }
}