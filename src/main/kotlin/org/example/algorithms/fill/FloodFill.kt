package org.example.algorithms.fill

import java.util.*
import kotlin.collections.HashSet

object FloodFill {
    // Pairs x, y
    // Array[rows][columns] ~ numRows = y, numCols = x
    // Assume square matrix
    fun fill(matrix: Array<IntArray>, startLocation: Pair<Int, Int>, fillValue: Int, boundaryValue: Int) {
        val numRows = matrix.size
        val numCols = matrix[0].size
        val queue: Queue<Pair<Int, Int>> = ArrayDeque()
        // Helps prevent duplicates addition
        val addedLocations: Array<BooleanArray> = Array(numRows) { BooleanArray(numCols) }
        queue.add(startLocation)
        addedLocations[startLocation.second][startLocation.first] = true

        while (queue.isNotEmpty()) {
            val node = queue.poll()
            if (isInside(matrix[node.second][node.first], boundaryValue) && matrix[node.second][node.first] != fillValue) {
                matrix[node.second][node.first] = fillValue
                // Add neighbours
                // Top
                if (hasNeighbour(Pair(node.first, node.second), Pair(numCols, numRows), Pair(0, 1))) {
                    val top = Pair(node.first, node.second - 1)
                    if (!addedLocations[top.second][top.first]) {
                        queue.add(top)
                        addedLocations[top.second][top.first] = true
                    }
                }
                // Right
                if (hasNeighbour(Pair(node.first, node.second), Pair(numCols, numRows), Pair(1, 0))) {
                    val right = Pair(node.first + 1, node.second)
                    if (!addedLocations[right.second][right.first]) {
                        queue.add(right)
                        addedLocations[right.second][right.first] = true
                    }
                }
                // Bottom
                if (hasNeighbour(Pair(node.first, node.second), Pair(numCols, numRows), Pair(0, -1))) {
                    val bottom = Pair(node.first, node.second + 1)
                    if (!addedLocations[bottom.second][bottom.first]) {
                        queue.add(bottom)
                        addedLocations[bottom.second][bottom.first] = true
                    }
                }
                // Left
                if (hasNeighbour(Pair(node.first, node.second), Pair(numCols, numRows), Pair(-1, 0))) {
                    val left = Pair(node.first - 1, node.second)
                    if (!addedLocations[left.second][left.first]) {
                        queue.add(left)
                        addedLocations[left.second][left.first] = true
                    }
                }
            }
        }
    }

    private fun isInside(value: Int, boundary: Int): Boolean {
        return value != boundary
    }

    private fun hasNeighbour(location: Pair<Int, Int>, matrixSize: Pair<Int, Int>, direction: Pair<Int, Int>): Boolean {
        val x = location.first
        val y = location.second

        return when {
            // Right
            direction.first == 1 -> x < matrixSize.first - 1
            // Left
            direction.first == -1 -> x > 0
            // Top
            direction.second == 1 -> y > 0
            // Bottom
            direction.second == -1 -> y < matrixSize.second - 1
            // Invalid
            else -> false
        }
    }
}