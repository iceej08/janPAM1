package com.example.prjpam1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.prjpam1.Praktikum4.BookingTicketScreen
import com.example.prjpam1.Praktikum4.CounterScreen
import com.example.prjpam1.Praktikum4.Repo
import com.example.prjpam1.ui.theme.PrjPAM1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookingTicketScreen()
//            PrjPAM1Theme{
//                var number by rememberSaveable { mutableStateOf(1) }
//                val snackbarHostState = remember { SnackbarHostState() }
//                Scaffold(
//                    modifier = Modifier.fillMaxSize(),
//                    snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
//                ){ innerPadding ->
//
//                    CounterScreen(
//                        Modifier
//                            .padding(innerPadding)
//                            .padding(32.dp),
//                        number = number,
//                        label = "Double",
//                        onButtonClick = { number *= 2 }
//                    )
//
//                    LaunchedEffect(number) {
//                        snackbarHostState.showSnackbar("Number $number is shown!")
//                    }
//                    LaunchedEffect(Unit) {
//                        number = Repo.getData()
//                    }

//                }
//
//
//
//            }




        }
    }
}


