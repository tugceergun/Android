package eu.tutorials.locationapp

import android.Manifest
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import eu.tutorials.locationapp.ui.theme.LocationAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LocationAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

//kullanicinin konumunu elde etmek ve guncellemek icin buton.
@Composable
fun LocationDisplay(
    locationUtils: LocationUtils,
    context: Context
){

    //izin baslaticisi //register a request to start an activity and handle the result
    // onResult -> results of the location permission requests
    val requestPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions() ,
        onResult = {permissions ->
            if(permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true
                && permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true){
                // izne sahibim
            }else{
                //izin iste
            }
        })

    Column( modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(text = "Location not available")
        
        Button(onClick = {
            if(locationUtils.hasLocationPermission(context)){
                //permission already granted update the location

            }else{
                //Request location permission
            }
        }) {
            Text(text = "Get Location")
        }
    }
}
