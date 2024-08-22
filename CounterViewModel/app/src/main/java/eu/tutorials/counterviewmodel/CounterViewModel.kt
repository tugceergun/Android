package eu.tutorials.counterviewmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel



class CounterViewModel : ViewModel(){
    private val _count =  mutableStateOf(0)

    //expose the count as an immutable state
    //sadece degeri disari cikar, degiskenin kendisi degil.
    val count : MutableState<Int> = _count

    fun increment(){
        _count.value += 1
    }

    fun decrement(){
        _count.value -= 1
    }
}

