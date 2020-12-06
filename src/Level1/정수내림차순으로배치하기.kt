import java.util.PriorityQueue

fun main(){
    println(solution1(12345678))
    println(solution1(12345687))
}

private val solution: (Long) -> Long = {
    val pq = PriorityQueue<Char>()
    var answer = ""
    it.toString().forEach{ c -> pq.add(c) }
    while(pq.isNotEmpty())
        answer = pq.poll() + answer
    answer.toLong()
} // 10배 느림

private fun solution1(n: Long): Long{
    val p = n.toString().toCharArray()
    for(i in p.indices){
        for(j in i until p.size){
            if(p[i] < p[j]){
                val tmp = p[i]
                p[i] = p[j]
                p[j] = tmp
            }
        }
    }
    return String(p).toLong()
} // 빠름