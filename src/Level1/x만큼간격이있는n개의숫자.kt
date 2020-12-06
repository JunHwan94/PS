fun main(){
    solution(2, 5).forEach{
        print(it)
    }
}
private fun solution(x: Int, n: Int): LongArray{
    val answer = LongArray(n){ 0 }
    for(i in 0 until n){
        answer[i] = x.toLong() * (i + 1)
    }
    return answer
}

private fun solution1(x: Int, n: Int) =
    LongArray(n){ 0 }.apply{
        generateSequence(x.toLong()){ it + x.toLong() }.take(n).forEach{
            this.indices.forEach{

            }
        }
    }