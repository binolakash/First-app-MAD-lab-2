package com.example.musicappui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties

@Composable
fun AccountDialog(dilogOpen: MutableState<Boolean>){
    if(dialogOpen.value){
        AlertDialog(
            onDismissRequest = {
                dialogOpen.value = false
            },
            confirmButton = {
                TextButton(onClick = {
                    dialogOpen.value = false
                }) {
                    Text(text="Confirm")
                }
            },
            dissmissButton = {
                TextButton(onClick = {
                    dialogopen.value = false
                }) {
                    Text(text="Dissmiss")
                }
            },
            title = {
                Text(text="Add Account")
            },
            text = {
                Column(modifier = Modifier.wrapContentHeight().padding(top = 16.dp),
                    verticalArrangement = Arrangement.Center
                ){
                    TextField(value = "", onValueChange = {

                    }, modifier = Modifier.padding(top = 16.dp),
                        label = {Text(text="Email")})
                    TextField(value="",onValueChange={

                    }, modifier = Modifier.padding(top = 8.dp),
                        label = {Text(text = "Password")})
                }
            },
            modifier = Modifier.fillMaxSize()
                .background(MaterialTheme.colors.primarySurface)
                .padding(8.dp),
            shape = RoundedCornerShape(5.dp),
            backgroundColor = Color.White,
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            )
        )
    }
}