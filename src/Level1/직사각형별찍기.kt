fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    repeat(b){
        repeat(a){
            print('*')
        }
        println()
    }
    generateSequence(-2.toLong()){ it + -2.toLong() }.take(3)
}