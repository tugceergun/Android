package eu.tutorials.unitconverter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eu.tutorials.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}

//Birim donusumu yapan uygulama. State management ile.
@Composable
fun UnitConverter(){

    //by kullaninca var yaptik cunku artik degerin direkt kendisine ulasip degistiriyoruz.
    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Meters") }
    var outputUnit by remember { mutableStateOf("Meters") }
    //menunun acilir olup olmamasi
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    //carpan katsayisi donusum icin
    val conversionFactor = remember { mutableStateOf(1.00) }
    val oConversionFactor = remember { mutableStateOf(1.00) }

    val customTextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 32.sp,
        color = Color.Black
    )


    //donusum icin fonksiyon.
    fun convertUnits(){

        //?: elvis operator
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.00
        val result = (inputValueDouble * conversionFactor.value * 100.0/oConversionFactor.value).roundToInt() / 100.0
        outputValue= result.toString()
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement= Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //column icinde alt alta yazar.
        Text("Unit Converter",
            style = customTextStyle
            )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = inputValue,
            onValueChange = {
            inputValue=it //inputValue girilen string olacak.
                convertUnits()
        },
            label = { Text(text = "Enter value")})

        Spacer(modifier = Modifier.height(16.dp))

        Row {

            //Row icinde ust uste yazar.
            //Input Box
            Box{
                //input button
                Button(onClick = { iExpanded = true}) {
                    Text(text = inputUnit)
                    Icon(Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded=false }) {
                    DropdownMenuItem(
                        text = { Text("Centimeters") },
                        onClick = {
                            iExpanded = false
                            inputUnit= "Centimeters"
                            conversionFactor.value= 0.01
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Meters") },
                        onClick = {
                            iExpanded = false
                            inputUnit= "Meters"
                            conversionFactor.value= 1.0
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Feet") },
                        onClick = {
                            iExpanded = false
                            inputUnit= "Feet"
                            conversionFactor.value= 0.3048
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Milimeters") },
                        onClick = {
                            iExpanded = false
                            inputUnit= "Milimeters"
                            conversionFactor.value= 0.001
                            convertUnits()
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            //Output Box
            Box{
                //output button
                Button(onClick = { oExpanded=true }) {
                    Text(text = outputUnit)
                    Icon(Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down")
                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded =false }) {
                    DropdownMenuItem(
                        text = { Text("Centimeters") },
                        onClick = {
                            oExpanded = false
                            outputUnit= "Centimeters"
                            oConversionFactor.value= 0.01
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Meters") },
                        onClick = {
                            oExpanded = false
                            outputUnit= "Meters"
                            oConversionFactor.value= 1.0
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Feet") },
                        onClick = {
                            oExpanded = false
                            outputUnit= "Feet"
                            oConversionFactor.value= 0.3048
                            convertUnits()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Milimeters") },
                        onClick = {
                            oExpanded = false
                            outputUnit= "Milimeters"
                            oConversionFactor.value= 0.001
                            convertUnits()
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        //Result text
        Text("Result: $outputValue $outputUnit",
            style = MaterialTheme.typography.headlineMedium
            )
    }
}


@Preview(showBackground = true)
@Composable
fun UnitConverterPreview(){
    UnitConverter()
}
