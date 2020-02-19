package org.example.algorithms

import org.example.algorithms.datastructures.trees.Node

fun main() {
    val tree = Node(6)
        .insert(Node(4)
            .insert(Node(3))
            .insert(Node(5)))
        .insert(Node(8)
            .insert(Node(7))
            .insert(Node(9)))
//    Node.dfs(tree)
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
}
