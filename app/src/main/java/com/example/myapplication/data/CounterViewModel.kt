package com.example.myapplication.data

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.myapplication.CounterIntent
import com.example.myapplication.ui.state.CounterState

class CounterViewModel : ViewModel() {
    private val _state = mutableStateOf(CounterState())
    val state: State<CounterState> = _state

    fun processIntent(intent: CounterIntent) {
        when (intent) {
            CounterIntent.Increment -> increment()
            CounterIntent.Decrement -> decrement()
            CounterIntent.Reset -> reset()
        }
    }

    private fun increment() {
        _state.value = _state.value.copy(
            count = _state.value.count + 1
        )
    }

    private fun decrement() {
        _state.value = _state.value.copy(
            count = _state.value.count - 1
        )
    }

    private fun reset() {
        _state.value = _state.value.copy(
            count = 0
        )
    }
}