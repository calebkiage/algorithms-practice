package org.example.algorithms

import org.example.algorithms.datastructures.linkedlist.Node
import org.example.algorithms.datastructures.trees.BinaryNode
import org.example.algorithms.datastructures.trees.NonBinaryNode
import org.example.algorithms.datastructures.trees.Tree
import org.example.algorithms.fill.FloodFill
import org.example.algorithms.datastructures.trees.Node as TreeNode

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

    val tree3Root = TreeNode(6)
        .insert(TreeNode(4)
            .insert(TreeNode(3))
            .insert(TreeNode(5)))
        .insert(TreeNode(8)
            .insert(TreeNode(7))
            .insert(TreeNode(9)))
    val tree3 = Tree(tree3Root)
    println("DFS Traversal (Pre-order):")
    tree3.dfsPreOrderTraversal()
    println("\nDFS Traversal (Post-order):")
    tree3.dfsPostOrderTraversal()
    println("\nBFS Traversal:")
    tree3.bfsTraversal()

    val linkedList = Node(1, Node(2, Node(3)))
    val reversed = Node.reverse(linkedList)

    // 0, 0, -1
    // 0, -1, 0
    // -1, 0, 0
    val matrix: Array<IntArray> = arrayOf(intArrayOf(0,0,-1), intArrayOf(0,-1,0), intArrayOf(-1,0,0))
    FloodFill.fill(matrix, startLocation = Pair(0, 0), fillValue = 1, boundaryValue = -1)
}
