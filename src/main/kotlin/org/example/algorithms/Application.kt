package org.example.algorithms

import org.example.algorithms.datastructures.linkedlist.Node
import org.example.algorithms.datastructures.trees.BinaryNode
import org.example.algorithms.datastructures.trees.NonBinaryNode

fun main() {
    val tree = NonBinaryNode(6)
        .insert(NonBinaryNode(4)
            .insert(NonBinaryNode(3))
            .insert(NonBinaryNode(5)))
        .insert(NonBinaryNode(8)
            .insert(NonBinaryNode(7))
            .insert(NonBinaryNode(9)))

    println("DFS (Pre-order):")
    var res = tree.dfsPreOrder(13)
    println("\nDFS (Post-order)")
//    println(res?.value)
    res = tree.dfsPostOrder(13)
    println("\nBFS")
//    println(res?.value)
    res = tree.bfs(13)
    println("\n\n")
//    println(res?.value)
    val tree2 = BinaryNode(6)
        .insert(BinaryNode(4)
            .insert(BinaryNode(3))
            .insert(BinaryNode(5)))
        .insert(BinaryNode(8)
            .insert(BinaryNode(7))
            .insert(BinaryNode(9)))

    println("DFS (Pre-order):")
    var res2 = tree2.dfsPreOrder(13)
    println("\nDFS (Post-order)")
//    println(res2?.value)
    res2 = tree2.dfsPostOrder(13)
    println("\nDFS (In-order)")
//    println(res2?.value)
    res2 = tree2.dfsInOrder(13)
    println("\nBFS")
//    println(res2?.value)
    res2 = tree2.bfs(13)
    println("\n\n")
//    println(res2?.value)

    val linkedList = Node(1, Node(2, Node(3)))
    val reversed = Node.reverse(linkedList)
}
