package baekjoon
import java.util.*

private fun main(){
    val sc = Scanner(System.`in`)
    var input = sc.nextInt()
    val init = input
    var answer = 0
    while(0 < input){
        if(input % 11 == 0){
            answer = input / 11 * 3
            break
        }
        else if(input >= 8 && input % 8 == 0){
            answer += (input / 8) * 2
            break
        }else if(input == 4){
            answer = -1
            break
        }else if(input % 5 != 0 && input % 3 == 0){
            answer += input / 3
            break
        }
        input -= 5
        answer++

        if(input == 1 || input == 2){
            answer = -1
            break
        }
    }
    if(answer == -1 && init % 3 == 0) answer = init / 3
    print(answer)
}