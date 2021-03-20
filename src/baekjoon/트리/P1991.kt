package baekjoon.트리

import kotlin.collections.HashSet

private lateinit var tTree: Array<CharArray>
fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val nodeSet = HashSet<Char>()
    tTree = Array(27) { CharArray(2) }.apply {
        repeat(N) {
            val input = br.readLine().split(" ")
            val node = input[0].toCharArray()[0].also { nodeSet.add(it) }
            val left = input[1].toCharArray()[0].also { nodeSet.add(it) }
            val right = input[2].toCharArray()[0].also { nodeSet.add(it) }
            this[node.toInt() - 64][0] = left
            this[node.toInt() - 64][1] = right
        }
    }.also { it.forEach { cArr -> cArr.forEach { c -> nodeSet.remove(c) } } }

    val root = nodeSet.toArray()[0] as Char
    preOrder(root.toInt() - 64)
    println()
    inOrder(root.toInt() - 64)
    println()
    postOrder(root.toInt() - 64)
}

fun preOrder(i: Int){
    if(i >= tTree.size) return
    val c = (i + 64).toChar()
    if(c != '.') {
        print(c)
        preOrder(tTree[i][0].toInt() - 64)
        preOrder(tTree[i][1].toInt() - 64)
    }
}

fun inOrder(i: Int){
    if(i >= tTree.size) return
    val c = (i + 64).toChar()
    if(c != '.') {
        inOrder(tTree[i][0].toInt() - 64)
        print(c)
        inOrder(tTree[i][1].toInt() - 64)
    }
}

fun postOrder(i: Int){
    if(i >= tTree.size) return
    val c = (i + 64).toChar()
    if(c != '.') {
        postOrder(tTree[i][0].toInt() - 64)
        postOrder(tTree[i][1].toInt() - 64)
        print(c)
    }
}

/*
3
A C D
B E .
C B .

4
A B .
B C .
C D .
D . .

26
A B C
B D .
C E F
E . .
F . G
D . .
G H .
H I .
I J .
J K .
K L .
L M .
M N .
N O .
O P .
P Q .
Q R .
R S .
S T .
T U .
U V .
V W .
W X .
X Y .
Y Z .
Z . .

5
A B C
D E .
B D .
C . .
E . .
 */