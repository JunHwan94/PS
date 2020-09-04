package Level1

import java.util.*

fun main(){
    val board = arrayOf(intArrayOf(0, 0, 0, 0, 0), intArrayOf(0, 0, 1, 0, 3), intArrayOf(0, 2, 5, 0, 1), intArrayOf(4, 2, 4, 4, 2), intArrayOf(3, 5, 1, 3, 1))
    val moves = intArrayOf(1, 5, 3, 5, 1, 2, 1, 4)
    print(solution(board, moves))
}

// answer == 4
fun solution(board: Array<IntArray>, moves: IntArray): Int{
    var answer = 0

    val dollStacks = Array<Stack<Int>>(board.size){ Stack() }
    val takenDolls = Stack<Int>()
    var i = 0
    do{
        var j = board.size - 1
        do{
            when(board[j][i]){
                0 -> {}
                else -> dollStacks[i].push(board[j][i])
            }
            j--
        }while(j >= 0)
        i++
    }while(i < board.size)

    moves.forEach { position ->
        if (dollStacks[position - 1].isNotEmpty()) {
            when {
                dollStacks[position - 1].peek() != 0 -> {
                    takenDolls.forEach { print(it) }
                    println()
                    if (takenDolls.isNotEmpty() &&
                            dollStacks[position - 1].peek() == takenDolls.peek()) {
                        dollStacks[position - 1].pop()
                        takenDolls.pop()
                        answer += 2
                    } else {
                        takenDolls.push(dollStacks[position - 1].pop())
                    }
                    print("\n${position-1} ")
                    dollStacks.forEach{
                        print(it)
                    }
                    println()
                }
                else -> {}
            }
        }
    }
    println()
    return answer
}
// 4 3 1 1 3 2 4
// 4 3 3 2 4