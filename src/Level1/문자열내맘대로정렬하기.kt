package Level1

fun main(){
    solution(arrayOf("sun", "bed", "car"), 1).forEach{print(it)}
    println()
    print(solution(arrayOf("abce", "cdxc", "abcd", "cabb", "abaa", "caxa"), 2).toList())
}

private fun solution(strings: Array<String>, n: Int) =
    strings.also{
        it.sort() // 사전순 정렬
        it.sortBy{ it[n] } // n번째 기준 사전순 정렬
    }

// abce, cdxc, abcd, cabb, abaa, caxa
// abaa, abcd, abce, cabb, caxa, cdxc
// abaa, cabb, abcd, abce, caxa, cdxc

//val chars = ArrayList<Char>()
//var i = 0
//do{
//    when {
//        strings[i][n] in chars -> {}
//        else -> chars.add(strings[i][n])
//    }
//    i++
//}while(i < strings.size)
//chars.sort()
//
//val aList = ArrayList<ArrayList<String>>(chars.size)
//repeat(chars.size){ aList.add(arrayListOf()) }
//i = 0
//do{
//    var j = 0
//    do{
//        if(strings[i][n] == chars[j]) aList[j].add(strings[i])
//        aList[j].sort()
//        j++
//    }while(j < chars.size)
//    i++
//}while(i < strings.size)
//return aList.flatten().toTypedArray()