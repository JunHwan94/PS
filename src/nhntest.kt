fun main(){
    val n = readLine()!!.toInt()
    val array = Array(n){ Array(n){ 0 } }

    for(i in 0 until n){
        val line = readLine()!!.split(" ")
        for(j in 0 until n){
            val area1 = line[j].toInt()
            if(area1 == 1)
                array[i][j] = area1
        }
    }

    // 전체 반복 한번더
    // 처음 1 위치 기준잡고 인접 영역 확인 - 오른쪽, 아래쪽(왼쪽, 아래쪽) 인덱스 늘려가면서 확인하고
    // area 에 add 후 area 안에 있는 원소 기준으로 반복. area.size로 크기 계산
    var areas = 0
    var areaIdxs = ArrayList<Pair<Int, Int>>()
    var i = 0
    var j = 0
    while(i < n){
        while(j < n) {
            if(array[i][j] == 1) {
                if (areaIdxs.isEmpty()) {
                    areaIdxs.add(Pair(i, j))
                }else {
                    for (idx in 0 until areaIdxs.size) {
                        if(areaIdxs[idx].first + 1 == i && areaIdxs[idx].second == j) {
                            val pair = Pair(i, j)
                            areaIdxs.add(pair)
                            val leftPair = Pair(i, j - 1)
                            if(array[i][j - 1] == 1 && areaIdxs[idx].first + 1 == i && areaIdxs[idx].second - 1 == j && !areaIdxs.contains(leftPair))
                                areaIdxs.add(leftPair)
                        }
                    }
                }
            }
            j++
        }
        i++
    }

    println(n)
    array.forEach{
        it.forEach{
            num -> print(num)
        }
        println()
    }
}

private fun solution(){

}