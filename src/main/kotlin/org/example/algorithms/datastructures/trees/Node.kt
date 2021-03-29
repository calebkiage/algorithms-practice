package org.example.algorithms.datastructures.trees

class Node<T: Comparable<T>>(val value: T) {
    val children: MutableList<Node<T>> = mutableListOf()

    fun insert(node: Node<T>): Node<T> {
        this.children.add(node)
        return this
    }

    override fun toString(): String {
        return "Node($value)"
    }
}