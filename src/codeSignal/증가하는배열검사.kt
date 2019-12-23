package codeSignal

fun main(){
    println(almostIncreasingSequence(mutableListOf(1,2,3,4,5,-10)))
    println(almostIncreasingSequence(mutableListOf(1,3,2,1)))
    println(almostIncreasingSequence(mutableListOf(10,1,2,3,4,5)))
    println(almostIncreasingSequence(mutableListOf(0,-2,5,6)))
    println(almostIncreasingSequence(mutableListOf(1,2,5,3,5)))

//    println(listOf(1,2,3,4,3,2,1).dropWhile { it <= 2 }) // 조건에 맞으면 계속 drop
//    println(listOf(1,2,3,4).dropLastWhile { it == 2 })

}
fun almostIncreasingSequence(sequence: MutableList<Int>): Boolean {
    var i = 0; val list: MutableList<Int> = mutableListOf()
    while(i < sequence.size){
        when(i){
            0 -> if(sequence[0] < sequence[1]) list.add(sequence[0]) else sequence.removeAt(0)
            else -> if(sequence.withIndex().filter{ it.index < i && it.value >= sequence[i]}.count() == 0) list.add(sequence[i])
        }
        i++
    }
    println(list)
    return list.size == sequence.size - 1 && list.zipWithNext(Int::minus).filter{ it == 0 }.count() == 0
}