package baekjoon.함수

fun main(){
    System.out.bufferedWriter().run {
        val arr = IntArray(10001)
        val sb = StringBuffer()
        for(i in 1..10000){
            val d = d(i)
            if(d <= 10000) arr[d] = 1
        }
        for(i in 1..10000){
            if(arr[i] == 0)
                sb.append("$i\n")
        }
        write(sb.toString())
        flush()
        close()
    }
}

fun d(n: Int) = n + s(n)

fun s(n: Int): Int {
    return if (n < 10) n
    else s(n / 10) + n % 10
}