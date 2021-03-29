package org.example.algorithms.datastructures.trees

import java.util.*

class Tree<T: Comparable<T>>(val root: Node<T>) {
    fun printTree(appender: String = "-") {
//        val addition = if (this.parent != null) appender else ""
//        println("$addition${this.value}")
//
//        for (child in children) {
//            child.printTree("-$appender")
//        }
    }

    // Print nodes
    fun dfsPreOrderTraversal() {
        val traversed = mutableSetOf<Node<T>>()
        val items: Deque<Node<T>> = ArrayDeque()
        items.push(root)

        while (items.isNotEmpty()) {
            val current = items.pop()
            if (!traversed.contains(current)) {
                traversed.add(current)
                print("${current.value} ")
            }

            for (child in current.children.asReversed()) {
                if (!traversed.contains(child)) {
                    items.push(child)
                }
            }
        }
    }

    fun dfsPostOrderTraversal() {
        val items: Deque<Node<T>> = ArrayDeque()
        val outStack: Deque<Node<T>> = ArrayDeque()

        items.push(root)

        while (items.isNotEmpty()) {
            val current = items.pop()
            outStack.push(current)
            for (child in current.children) {
                items.push(child)
            }
        }

        while (outStack.isNotEmpty()) {
            val curr = outStack.pop()
            print("${curr.value} ")
        }
    }

    fun bfsTraversal() {
        val queue: Queue<Node<T>> = LinkedList()

        queue.add(root)

        while (queue.isNotEmpty()) {
            val node = queue.remove()
            print("${node.value} ")

            queue.addAll(node.children)
        }
    }
}