package org.example.algorithms.datastructures.trees

import java.util.*

class Node<T>(val value: T) {
    val children: MutableList<Node<T>> = mutableListOf()

    // Root node has no parent
    var parent: Node<T>? = null

    fun insert(node: Node<T>): Node<T> {
        node.parent = this
        this.children.add(node)
        return this
    }

    fun printTree(appender: String = "-") {
        val addition = if (this.parent != null) appender else ""
        println("$addition${this.value}")

        for (child in children) {
            child.printTree("-$appender")
        }
    }

    fun dfsPreOrder(value: T): Node<T>? {
        print("${this.value} ")
        if (this.value == value) {
            return this
        } else {
            for (child in children) {
                val res = child.dfsPreOrder(value)
                if (res != null) {
                    return res
                }
            }
        }
        return null
    }

    fun dfsPostOrder(value: T): Node<T>? {
        for (child in children) {
            val res = child.dfsPostOrder(value)
            if (res != null) {
                return res
            }
        }
        print("${this.value} ")

        if (this.value == value) {
            return this
        }

        return null
    }

    fun bfs(value: T): Node<T>? {
        // use queue to keep track of siblings.
        val nodes: Queue<Node<T>> = LinkedList()

        // start the search from this node
        nodes.add(this)

        while (nodes.isNotEmpty()) {
            val node = nodes.remove()
            print("${node.value} ")

            if (node.value == value) {
                return node
            } else {
                for (child in node.children) {
                    nodes.add(child)
                }
            }
        }

        return null
    }
}