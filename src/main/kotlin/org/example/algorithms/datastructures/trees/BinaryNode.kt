package org.example.algorithms.datastructures.trees

import java.util.*

class BinaryNode<T: Comparable<T>>(val value: T) {
    var leftNode: BinaryNode<T>? = null
    var rightNode: BinaryNode<T>? = null

    // Root node has no parent
    var parent: BinaryNode<T>? = null

    fun insert(node: BinaryNode<T>): BinaryNode<T> {
        node.parent = this
        if (node.value < this.value) {
            if (leftNode != null) {
                leftNode?.insert(node)
            } else {
                leftNode = node
            }
        } else {
            if (rightNode != null) {
                rightNode?.insert(node)
            } else {
                rightNode = node
            }
        }

        return this
    }

//    fun printTree(appender: String = "-") {
//        val addition = if (this.parent != null) appender else ""
//        println("$addition${this.value}")
//
//        for (child in children) {
//            child.printTree("-$appender")
//        }
//    }

    fun dfsPreOrder(value: T): BinaryNode<T>? {
        print("${this.value} ")
        if (this.value == value) {
            return this
        } else {
            val left = leftNode
            val right = rightNode
            if (left != null) {
                val res = left.dfsPreOrder(value)
                if (res != null) {
                    return res
                }
            }

            if (right != null) {
                val res = right.dfsPreOrder(value)
                if (res != null) {
                    return res
                }
            }
        }
        return null
    }

    fun dfsPostOrder(value: T): BinaryNode<T>? {
        val res1 = leftNode?.dfsPostOrder(value)
        if (res1 != null) {
            return res1
        }

        val res2 = rightNode?.dfsPostOrder(value)
        if (res2 != null) {
            return res2
        }

        print("${this.value} ")

        if (this.value == value) {
            return this
        }

        return null
    }

    fun dfsInOrder(value: T): BinaryNode<T>? {
        val res1 = leftNode?.dfsInOrder(value)
        if (res1 != null) {
            return res1
        }

        print("${this.value} ")
        if (this.value == value) {
            return this
        }

        val res2 = rightNode?.dfsInOrder(value)
        if (res2 != null) {
            return res2
        }

        return null
    }

    fun bfs(value: T): BinaryNode<T>? {
        // use queue to keep track of siblings.
        val nodes: Queue<BinaryNode<T>> = LinkedList()

        // start the search from this node
        nodes.add(this)

        while (nodes.isNotEmpty()) {
            val node = nodes.remove()
            print("${node.value} ")

            if (node.value == value) {
                return node
            } else {
                nodes.addAll(setOf(node?.leftNode, node?.rightNode).filterNotNull())
            }
        }

        return null
    }
}