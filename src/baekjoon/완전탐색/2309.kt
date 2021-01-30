package baekjoon.완전탐색.P2309

// 난쟁이
val arr = IntArray(9)
val visited = BooleanArray(9)
val printArr = IntArray(7)
fun main(){
    for(i in arr.indices){
        arr[i] = Integer.parseInt(readLine())
    }
    selectDwarf(0, 0)
}

var isOver = false
/**
 * @param sum 현재 뽑은 값들의 합
 * @param depth 현재 탐색 깊이
 * @return Unit
 */
fun selectDwarf(sum: Int, depth: Int){
    if(isOver) return
    when{
        sum == 100 && depth == 7 -> { // 탐색 깊이 7이고 뽑은 난쟁이 키 합이 100일 때
            // 뽑은 난쟁이들 정렬해서 하나씩 출력
            printArr.sorted().forEach { println(it) }
            //끝
            isOver = true
            return
        }
        depth > 6 -> return
        sum > 100 -> return
    }

    for(i in arr.indices){
        if(!visited[i]){
            visited[i] = true
            printArr[depth] = arr[i]
            selectDwarf(sum + arr[i], depth + 1)
            visited[i] = false
        }
    }
}