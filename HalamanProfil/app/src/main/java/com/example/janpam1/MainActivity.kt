package com.example.janpam1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.janpam1.ui.theme.JanPAM1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LIFECYCLE_TEST", "onCreate dipanggil")
        setContent {
            JanPAM1Theme {
                HalamanProfil()
            }
        }
    }
    override fun onStart(){
        super.onStart()
        Log.d("LIFECYCLE_TEST", "onStart dipanggil")
    }
    override fun onResume(){
        super.onResume()
        Log.d("LIFECYCLE_TEST", "onResume dipanggil")
    }
    override fun onPause(){
        super.onPause()
        Log.d("LIFECYCLE_TEST", "onPause dipanggil")
    }
    override fun onStop(){
        super.onStop()
        Log.d("LIFECYCLE_TEST", "onStop dipanggil")
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.d("LIFECYCLE_TEST", "onDestroy dipanggil")
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    JanPAM1Theme {
//        Greeting("Android")
//    }
//}