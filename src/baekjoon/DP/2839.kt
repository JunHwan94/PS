package baekjoon.DP

private fun main(){
    System.`in`.bufferedReader().readLine().toInt().also { n ->
        Array(n + 1) { if (it == 3 || it == 5) 1 else -1 }.apply{
            for (i in 6..n) {
                val m3 = this[i - 3]
                val m5 = this[i - 5]
                when {
                    m3 == -1 && m5 == -1 -> this[i] = -1
                    m3 == -1 -> this[i] = m5 + 1
                    m5 == -1 -> this[i] = m3 + 1
                    m3 < m5 -> this[i] = m3 + 1
                    m5 < m3 -> this[i] = m5 + 1
                    else -> this[i] = m5 + 1
                }
            }
        }.also{ println(it[n]) }
    }
}