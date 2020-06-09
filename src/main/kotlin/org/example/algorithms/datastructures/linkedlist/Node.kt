package org.example.algorithms.datastructures.linkedlist

class Node(var value: Int, var next: Node? = null) {
    companion object {
        fun reverse(head: Node?): Node? {
            var prev: Node? = null
            var current: Node? = head
            var next = head?.next

            while (current != null) {
                next = current.next
                current.next = prev
                prev = current
                current = next
            }

            return prev
        }
    }
}
