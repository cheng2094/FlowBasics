package com.example.flowbasics

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main(){

    runBlocking {
        takeOperator()
        reduceOperator()
        flowOnOperator()
    }
}

suspend fun flowOnOperator(){
    (1..10).asFlow()
        .flowOn(Dispatchers.IO)
        .collect{
            println("FlowOn: $it")
        }
}

suspend fun reduceOperator(){
    val size = 5
    val factorial = (1..size).asFlow()
        .reduce{ accumulator, value ->
            accumulator * value
        }
    println("Reduce: Factorial of $size is $factorial")
}

suspend fun takeOperator(){
    (1..10).asFlow()
        .take(2)
        .collect{
            println("Take: $it")
        }
}