package baekjoon.정렬


// 수 정렬하기 2
fun main(){
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = Integer.parseInt(br.readLine())
    val sb = StringBuffer()
    val arr = BooleanArray(2_000_001).apply{
        repeat(n){
            val input = Integer.parseInt(br.readLine()) + 1_000_000
            this[input] = true
        }
    }
    for(i in 0 until 2_000_001){
        if(arr[i]) sb.append("${i - 1_000_000}\n")
    }
    bw.run{
        write(sb.toString())
        flush()
        close()
    }
    br.close()
}