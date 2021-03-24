package org.example.algorithms.strings

val str = "onceuponatimes"

fun isWord(input: String): Boolean {
    return when (input) {
        "on", "once", "up", "upon", "a", "at", "time", "me" -> true
        else -> false
    }
}

fun addSpaces(input: String): String {
    var lastSpace = 0
    var i = 0
    var result = input
    while (i < input.length) {
        if (i > lastSpace && input[i] == ' ') {
            lastSpace = i + 1
        }
        i++
    }

    i = lastSpace + 1
    while (i <= input.length) {
        val test = input.substring(lastSpace, i)
        if (isWord(test) && hasNextWord(input.substring(i, input.length))) {
            val newStr = "${input.substring(0, i)} ${input.substring(i, input.length)}"
            result = addSpaces(newStr)
        }
        i++
    }

    return result
}

fun hasNextWord(input: String): Boolean {
    var i = 0
    while (i < input.length) {
        if (isWord(input.substring(0, i + 1))) {
            return true
        }
        i++
    }

    return false
}

fun main() {
    val res = addSpaces(str)
    println(res)
}