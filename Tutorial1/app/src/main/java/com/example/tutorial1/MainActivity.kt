package com.example.tutorial1

import android.os.Bundle
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
import com.example.tutorial1.ui.theme.Tutorial1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tutorial1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Tutorial1Theme {
        Greeting("Android")
    }
}

fun tut1(){
    var modules = arrayOf("ESD","ITP","DSA","PS","PNS","MAD")
    println(modules)
}

fun marks(mark:Int){
    if(mark>75){
        println("A")
    }else if(mark>65){
        println("B")
    }else if(mark>50){
        println("C")
    }else if(mark>35){
        println("D")
    }else{
        println("F")
    }
}

fun map(){
    val grade = mapOf("stu1" to "A", "stu2" to "B","stu3" to "C")
    println(grade["stu1"])
}



