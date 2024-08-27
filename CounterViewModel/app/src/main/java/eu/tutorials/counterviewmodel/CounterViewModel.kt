package eu.tutorials.counterviewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel



class CounterViewModel() : ViewModel(){
    private val _repository: CounterRepository = CounterRepository()
    private val _count =  mutableStateOf(_repository.getCounter().count)

    //expose the count as an immutable state
    //sadece degeri disari cikar, degiskenin kendisi degil.
    val count : MutableState<Int> = _count

    fun increment(){
        //_count.value += 1
        _repository.incrementCounter()
        _count.value = _repository.getCounter().count
    }

    fun decrement(){
        //_count.value -= 1
        _repository.decrementCounter()
        _count.value = _repository.getCounter().count
    }
}

