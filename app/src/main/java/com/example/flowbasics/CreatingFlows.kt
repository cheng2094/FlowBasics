package com.example.flowbasics

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

fun main(){
    runBlocking {
        sendNumbers().collect(){
            println("sendNumbers Received $it")
        }

        sendNumbers2().collect(){
            println("sendNumbers2 Received $it")
        }

        sendNumbers3().collect(){
            println("sendNumbers3 Received $it")
        }
    }
}

fun sendNumbers() = flow{
    for(i in 1..10)
        emit(i)
}

fun sendNumbers2() = listOf(1,2,3).asFlow()

fun sendNumbers3() = flowOf("One", "Two", "Three")