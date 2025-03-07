package com.example.unitconverter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
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
fun UnitConverter(){

    var inputValue by remember { mutableStateOf(value="") }
    var outputValue by remember { mutableStateOf(value="") }
    var inputUnit by remember { mutableStateOf(value="Centimeters") }
    var outputUnit by remember { mutableStateOf(value="Meters") }
    var iExpanded by remember { mutableStateOf(value=false) }
    var oExpanded by remember { mutableStateOf(value=false) }
    val conversionFactor = remember { mutableStateOf(value=1.00) }
    val oConversionFactor = remember { mutableStateOf(value=1.00) }

        val customTextStyle = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontSize = 32.sp,
            color = Color.Red
        )



    fun convertUnits(){
        val inputValueDouble = inputValue.toDouble() ?: 0.0
        val result = (inputValueDouble * conversionFactor.value * 100.0/oConversionFactor.value).roundToInt() /100.0
        outputValue = result.toString()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Unit Converter", style = customTextStyle)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
                value = inputValue,
                onValueChange = {"it=String"
                inputValue = it
                    convertUnits()
        }, label = {Text(text="Enter the value")}
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row {
            //Input box
            Box   {
                //Input button
                Button(onClick = {iExpanded = true}) {
                    Text(text = inputUnit)
                    Icon(Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false }){
                    DropdownMenuItem(
                        text = { Text(text="Centimeters")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "Centimeters"
                            conversionFactor.value = 0.01

                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text="Meters")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "Meters"
                            conversionFactor.value = 1.0
                        }
                    )
                    DropdownMenuItem(
                        text = {Text(text="Feet")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "Feet"
                            conversionFactor.value = 0.3048
                        }
                    )
                    DropdownMenuItem(
                        text = {Text(text="Milimeters")},
                        onClick = {
                            iExpanded = false
                            inputUnit = "Milimeters"
                            conversionFactor.value = 0.001
                        }
                    )

                }

            }
            Spacer(modifier = Modifier.width(16.dp))

            //Output box
            Box  {
                //Output box
                Button(onClick = {oExpanded= true}) {
                    Text(text = outputUnit)
                    Icon(Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = {oExpanded = false}) {
                    DropdownMenuItem(
                        text = {Text(text="Centimeters") },
                        onClick = {
                            oExpanded = false
                            outputUnit = "Centimeters"
                            oConversionFactor.value = 0.01
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = {Text(text="Meters")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "Meters"
                            oConversionFactor.value = 1.00
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = {Text(text="Feet")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "Feet"
                            oConversionFactor.value =0.3048
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = {Text(text="Milimeters")},
                        onClick = {
                            oExpanded = false
                            outputUnit = "Milimeters"
                            oConversionFactor.value = 0.001
                            convertUnits()
                        }
                    )
                }
            }
        }

        Text(text="Result: $outputValue $outputUnit",

            style = MaterialTheme.typography.headlineMedium
        )
    }

}


@Composable
fun GreetingPreview() {

    UnitConverterTheme {
        Greeting("Android")
    }
}

@Composable
fun UnitConverterPreview() {
    UnitConverter()
}


