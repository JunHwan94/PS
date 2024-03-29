package baekjoon.트리

import kotlin.collections.HashSet

private lateinit var tree: Array<CharArray>
fun main() {
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    val nodeSet = HashSet<Char>()
    tree = Array(27) { CharArray(2) }.apply {
        repeat(N) {
            val input = br.readLine().split(" ")
            val node = input[0].toCharArray()[0].also { nodeSet.add(it) }
            val left = input[1].toCharArray()[0].also { nodeSet.add(it) }
            val right = input[2].toCharArray()[0].also { nodeSet.add(it) }
            this[node.code - 64][0] = left
            this[node.code - 64][1] = right
        }
    }.also { it.forEach { cArr -> cArr.forEach { c -> nodeSet.remove(c) } } }

    val root = nodeSet.toArray()[0] as Char
    preOrder(root.code - 64)
    println()
    inOrder(root.code - 64)
    println()
    postOrder(root.code - 64)
}

fun preOrder(i: Int){
    if(i >= tree.size) return
    val c = (i + 64).toChar()
    if(c != '.') {
        print(c)
        preOrder(tree[i][0].code - 64)
        preOrder(tree[i][1].code - 64)
    }
}

fun inOrder(i: Int){
    if(i >= tree.size) return
    val c = (i + 64).toChar()
    if(c != '.') {
        inOrder(tree[i][0].code - 64)
        print(c)
        inOrder(tree[i][1].code - 64)
    }
}

fun postOrder(i: Int){
    if(i >= tree.size) return
    val c = (i + 64).toChar()
    if(c != '.') {
        postOrder(tree[i][0].code - 64)
        postOrder(tree[i][1].code - 64)
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