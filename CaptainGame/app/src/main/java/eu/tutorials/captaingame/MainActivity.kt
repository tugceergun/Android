package eu.tutorials.captaingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import eu.tutorials.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaptainGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CaptainGame()
                }
            }
        }
    }
}

// butona basildiginda direction degisen ve treasure miktari random true oldugunda artan, degisimleri state ile saglanan uygulama
@Composable
fun CaptainGame(){
    val direction = remember { mutableStateOf("North") }
    val treasuresFound = remember { mutableStateOf(0) }
    val stormOrTreasure = remember { mutableStateOf("")}
    //val treasuresFound by remember { mutableStateOf(0) }
    // by keyword ile kullansaydik treasuresFound.value dememize gerek kalmazdi. Direkt treasuresFound o degeri verirdi.

    Column{
        Text(text = "Current direciton: ${direction.value}")
        Text(text = "Treasures found: ${treasuresFound.value}")
        Text(text = "Storm or Treasure: ${stormOrTreasure.value}")

        Button(onClick = {

            direction.value="East"
            if(Random.nextBoolean()){
                treasuresFound.value += 1
                stormOrTreasure.value = "Found a treasure!"
            }else{
                stormOrTreasure.value= "Storm Ahead!"
            }


        }) {
            Text("Sail East")
        }

        Button(onClick = {

            direction.value="West"
            if(Random.nextBoolean()){
                treasuresFound.value += 1
                stormOrTreasure.value = "Found a treasure!"
            }else{
                stormOrTreasure.value= "Storm Ahead!"
            }

        }) {
            Text("Sail West")
        }

        Button(onClick = {

            direction.value="North"
            if(Random.nextBoolean()){
                treasuresFound.value += 1
                stormOrTreasure.value = "Found a treasure!"
            }else{
                stormOrTreasure.value= "Storm Ahead!"
            }

        }) {
            Text("Sail North")
        }

        Button(onClick = {

            direction.value="South"
            if(Random.nextBoolean()){
                treasuresFound.value += 1
                stormOrTreasure.value = "Found a treasure!"
            }else{
                stormOrTreasure.value= "Storm Ahead!"
            }

        }) {
            Text("Sail South")
        }

    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CaptainGameTheme {

    }
}