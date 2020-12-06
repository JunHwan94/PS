fun main(){
    solution(arrayOf(intArrayOf(1,2), intArrayOf(2,3)), arrayOf(intArrayOf(3,4), intArrayOf(5,6))).forEach{it.forEach{it1 -> print(it1)}}
}

private fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray>
    = Array(arr1.size){ row -> IntArray(arr1[0].size){ col -> arr1[row][col] + arr2[row][col] } }