package com.example.prjpam1.Praktikum4

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun CounterScreen(modifier: Modifier,
                  number: Int, label: String, onButtonClick: () -> Unit){
//    var number by remember { mutableStateOf(0) }
//    val label by remember { mutableStateOf("Increment 2") }
    Column(modifier) {
        Text(text = "$number", fontSize = 72.sp)
        Button(onClick = onButtonClick) {
            Text(text = "$label")
        }
    }
//    Column(modifier) {
//        Text(text = "$number", fontSize = 72.sp)
//        Button(onClick = { number+=2 }) {
//            Text(text = "$label")
//        }
//    }
}