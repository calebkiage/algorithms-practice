package org.example.concurrency

import kotlin.concurrent.thread
import kotlin.random.Random

fun main() {
    val threads = mutableListOf<Thread>()
    for (i in 1..4) {
        val task = Work(i)
        val thread = Thread(task)
        threads.add(thread)
        thread.start()
        println("i: $i")
    }

    var running = threads.size

    while (running > 0) {
        running = threads.count { it.isAlive }
    }
}

class Work(private val index: Int) : Runnable {
    var i2: Int = 0

    override fun run() {
        val waitTime = Random.nextLong(10, 10000)
        println("Work. Thread: ${Thread.currentThread().name}, Index: $index, Waiting: ${waitTime}ms")
        Thread.sleep(waitTime)
        i2 = index
        println("i2: $i2")
    }
}