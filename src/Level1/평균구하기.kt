fun main(){
    print(solution(intArrayOf(1, 2, 3, 4, 5)))
}

private fun solution(arr: IntArray) = arr.fold(.0){ acc, next -> acc + next } / arr.size