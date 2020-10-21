package org.example.algorithms.recursion

fun main() {
    val input = arrayOf(
        arrayOf(1, 1, 0, 0, 0),
        arrayOf(0, 1, 0, 0, 1),
        arrayOf(1, 0, 0, 1, 1),
        arrayOf(0, 0, 0, 0, 0),
        arrayOf(1, 0, 1, 0, 1)
    )

    println(countIslands(input))

    val input2 = arrayOf(
        arrayOf(1, 1, 0, 0, 0),
        arrayOf(0, 1, 0, 0, 1),
        arrayOf(1, 0, 0, 1, 1),
        arrayOf(0, 0, 0, 0, 0),
        arrayOf(1, 0, 1, 1, 0)
    )

    println(countIslands(input2))
}

fun countIslands(input: Array<Array<Int>>): Int {
    val visited = Array(input.size, init = {i -> Array(input[i].size) { false } })
    val rowSize = input.size
    val colSize = input[0].size
    var count = 0
    for (i in 0 until rowSize) {
        for (j in 0 until colSize) {
            val item = input[i][j]

            if (item == 1 && !visited[i][j]) {
                dfs(input, i, j, visited)
                count += 1
            }
        }
    }
    return count
}

fun dfs(input: Array<Array<Int>>, row: Int, column: Int, visited: Array<Array<Boolean>>) {
    // neighbors: N, NE, E, SE, S, SW, W, NW
    val columnSize = input[0].size
    val rowSize = input.size
    val neighbors = mutableListOf<Pair<Int, Int>>()

    // Has elements above
    if (row > 0) {
        val n = Pair(row - 1, column)
        neighbors.add(n)

        if (column < columnSize - 1) {
            val ne = Pair(row - 1, column + 1)
            neighbors.add(ne)
        }

        if (column > 0) {
            val nw = Pair(row - 1, column - 1)
            neighbors.add(nw)
        }
    }

    // Has elements below
    if (row < rowSize - 1) {
        val s = Pair(row + 1, column)
        neighbors.add(s)

        if (column < columnSize - 1) {
            val se = Pair(row + 1, column + 1)
            neighbors.add(se)
        }

        if (column > 0) {
            val sw = Pair(row + 1, column - 1)
            neighbors.add(sw)
        }
    }

    // Has elements to left
    if (column > 0) {
        val w = Pair(row, column - 1)
        neighbors.add(w)
    }

    // Has elements to right
    if (column < columnSize - 1) {
        val e = Pair(row, column + 1)
        neighbors.add(e)
    }

    visited[row][column] = true

    if (input[row][column] == 1) {
        // check neighbors recursively
        neighbors.forEach {
            if (!visited[it.first][it.second]) {
                dfs(input, it.first, it.second, visited)
            }
        }
    }
}
