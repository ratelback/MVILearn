package com.example.myapplication.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.CounterIntent
import com.example.myapplication.data.CounterViewModel

@Composable
fun CounterScreen(viewModel: CounterViewModel = viewModel()) {
    val state = viewModel.state.value

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Count: ${state.count}", fontSize = 24.sp)
        Row {
            Button(onClick = { viewModel.processIntent(CounterIntent.Increment) }) {
                Text("Increase")
            }
            Button(onClick = { viewModel.processIntent(CounterIntent.Decrement) }) {
                Text("decrement")
            }
            Button(onClick = { viewModel.processIntent(CounterIntent.Reset) }) {
                Text("reset")
            }
        }
    }
}