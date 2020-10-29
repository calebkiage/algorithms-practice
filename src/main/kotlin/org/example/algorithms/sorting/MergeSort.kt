package org.example.algorithms.sorting

fun sort(elements: Array<Int>): Array<Int> {
    if (elements.isEmpty() || elements.size == 1) return elements
    splitMerge(elements, 0, elements.size - 1)
    return elements
}

private fun splitMerge(inputArray: Array<Int>, start: Int = 0, end: Int = 0) {
    // Exit case: Do nothing if the difference between start & end is < 1 i.e. single element array.
    // For an array with 1 element, start == end is true
    // A single element array is sorted.
    if (start >= end) {
        return
    }

    // Find the mid point of the given array
    // At this point, end > start.
    // For array: [5, 4], start = 0, end = 1.
    // Middle = 0
    val middle = start + ((end - start) / 2)

    // Branch off from the start of array to the mid-point effectively splitting the input array.
    splitMerge(inputArray, start, middle)

    // At this point, every element from index start to middle is sorted.
    splitMerge(inputArray, middle + 1, end)

    // Split the array at the mid point. For odd length arrays, the left side is larger
    val leftArray = Array(middle - start + 1) { i -> inputArray[start + i] }
    val rightArray = Array(end - middle) { i -> inputArray[i + middle + 1] }

    // Run the merge function for elements in leftArray & rightArray
    merge(inputArray, leftArray, rightArray, start)
}

fun merge(inputArray: Array<Int>, leftArray: Array<Int>, rightArray: Array<Int>, startIndex: Int) {
    var index = startIndex // current index of merged sub-array

    var i = 0 // left array start
    var j = 0 // right array end

    while (i < leftArray.size && j < rightArray.size) {
        if (leftArray[i] <= rightArray[j]) {
            inputArray[index] = leftArray[i++]
        } else {
            inputArray[index] = rightArray[j++]
        }

        index++
    }

    while (i < leftArray.size) {
        inputArray[index++] = leftArray[i++]
    }

    while (j < rightArray.size) {
        inputArray[index++] = rightArray[j++]
    }
}

fun main() {
    val sorted = sort(arrayOf(5, 4, 3, 2, 1, 10))
    sorted.forEachIndexed { index, i ->
        print("$i")
        if (index < sorted.size - 1) print(" ")
    }
    println()
}
