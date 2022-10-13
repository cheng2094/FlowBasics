package com.example.flowbasics

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking

fun main(){

    runBlocking {
        mapOperator()
        filterOperator()
        transformOperator()
    }
}

suspend fun transformOperator(){
    (1..10).asFlow()
        .transform {
            emit("Emitting string value $it")
            emit(it)
        }
        .collect(){
            println("Transform: $it")
        }
}

suspend fun filterOperator(){
    (1..10).asFlow()
        .filter {
            it % 2 == 0
        }
        .collect(){
            println("Filter: $it")
        }
}

suspend fun mapOperator(){
    (1..10).asFlow()
        .map {
            delay(500L)
            "Mapping: $it"
        }
        .collect(){
            println(it)
        }
}