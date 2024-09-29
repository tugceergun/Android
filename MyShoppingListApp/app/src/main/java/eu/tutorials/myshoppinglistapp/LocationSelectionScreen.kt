package eu.tutorials.myshoppinglistapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState


//konum secim ekrani kurulumu. konumu ve secilen yerle ne yapilacagini soylememiz gerek.
@Composable
fun LocationSelectionScreen(
    location: LocationData,
    onLocationSelected: (LocationData) -> Unit){

    //kullanici konumu
    //LatLng google map konum bilgisi icinde var.
    val userLocation = remember{
        mutableStateOf(LatLng(location.latitude, location.longitude))
    }

    //google haritalar alan seciminde nerede olundugu
    var cameraPositionState =  rememberCameraPositionState{
        //kullanicinin bulundugu yere gore 10f kadar zoom yapma
        position = CameraPosition.fromLatLngZoom(userLocation.value, 10f)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        GoogleMap(
            modifier = Modifier.weight(1f).padding(top=16.dp),
            cameraPositionState = cameraPositionState,
            onMapClick = {
                userLocation.value = it // konum, kullanicinin tikladigi yer olacak.
                //override
            }
        ){
            //haritada dokunulan nokta isaretcisi
            Marker(state = MarkerState(position = userLocation.value))
        }

        var newLocation: LocationData

        Button(onClick = {
            newLocation = LocationData(userLocation.value.latitude, userLocation.value.longitude)
            onLocationSelected(newLocation) // yeni konumu secilen konum verisi olarak geciriyoruz.
        }){
           Text("Set Location" )
        }
    }

}


