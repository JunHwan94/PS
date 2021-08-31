package Level1

import java.util.*
import kotlin.collections.HashMap

// 직업군 추천
// 카카오 코테에서 푼 듯한 느낌?
fun main(){
    println(solution(arrayOf("SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"), arrayOf("PYTHON", "C++", "SQL"), intArrayOf(7, 5, 5)))
    println(solution(arrayOf("SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"), arrayOf("JAVA", "JAVASCRIPT"), intArrayOf(7, 5)))
}

fun solution(table: Array<String>, languages: Array<String>, preference: IntArray): String {
    val prefMap = HashMap<String, Int>().apply{
        for (i in languages.indices)
            this[languages[i]] = preference[i]
    }

    val pq = PriorityQueue<JobScore>()
    table.forEach {
        val split = it.split(" ")
        val name = split[0]

        var total = 0
        prefMap[split[1]]?.let { i -> total += i * 5 }
        prefMap[split[2]]?.let { i -> total += i * 4 }
        prefMap[split[3]]?.let { i -> total += i * 3}
        prefMap[split[4]]?.let { i -> total += i * 2}
        prefMap[split[5]]?.let { i -> total += i }

        pq.offer(JobScore(name, total))
    }

    return pq.poll().name
}

class JobScore(val name: String, var score: Int): Comparable<JobScore>{
    override fun compareTo(other: JobScore): Int {
        if(this.score == other.score) return name.compareTo(other.name)
        return (this.score - other.score) * -1
    }
}