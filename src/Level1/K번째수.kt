package Level1

fun main(){
    solution(intArrayOf(1, 5, 2, 6, 3, 7, 4), arrayOf(intArrayOf(2, 5, 3), intArrayOf(4, 4, 1), intArrayOf(1, 7, 3))).forEach {
        println(it)
    }
}

fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
    var answer = IntArray(commands.size, {0})
    var i = 0
    for(command in commands){
        val sortedArray = array.sliceArray(IntRange(command[0] - 1, command[1] - 1))
        sortedArray.sort()
        answer[i] = sortedArray[command[2] - 1]
        i++
    }
    return answer
}