package Level1

import java.util.*

fun main(){
    solution(intArrayOf(2,1,3,4,1)).forEach{
        println(it)
    }
}

private fun solution(numbers: IntArray): IntArray{
    var answer: IntArray
    var sums = LinkedList<Int>()
    var sum: Int
    for(i in 0 until numbers.size){
        for(j in i until numbers.size){
            sum = numbers[i] + numbers[j]
            if(i != j && !sums.contains(sum)) sums.add(sum)
        }
    }
    answer = sums.sorted().toList().toIntArray()
    return answer
}