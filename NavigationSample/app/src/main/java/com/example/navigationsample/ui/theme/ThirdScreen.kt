package com.example.navigationsample.ui.theme

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ThirdScreen(navigateToFirstScreen:()->Unit){
    Button(onClick = {navigateToFirstScreen()}) {
        Text(text="This is the Third Screen.Go to First Screen")
    }

}

@Preview
@Composable
fun ThirdPreview(){
    ThirdScreen({})
}