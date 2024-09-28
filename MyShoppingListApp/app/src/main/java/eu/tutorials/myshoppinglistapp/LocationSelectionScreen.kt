package eu.tutorials.myshoppinglistapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.rememberCameraPositionState


//konum secim ekrani kurulumu. konumu ve secilen yerle ne yapilacagini soylememiz gerek.
@Composable
fun LocationSelectionScreen(
    location: LocationData,
    onLocationSelected: (LocationData) -> Unit){

    //kullanici konumu
    val userLocation = remember{
        mutableStateOf(LatLng(location.latitude, location.longitude))
    }

    //google haritalar alan seciminde nerede olundugu
    var cameraPositionState =  rememberCameraPositionState{
        //kullanicinin bulundugu yere gore 10f kadar zoom yapma
        position = CameraPosition.fromLatLngZoom(userLocation.value, 10f)
    }

}


