package eu.tutorials.myshoppinglistapp

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LocationViewModel: ViewModel() {
    private val _location = mutableStateOf<LocationData?>(null)
    val location : State<LocationData?> = _location

    private val _address = mutableStateOf(listOf<GeocodingResult>())
    val address : State<List<GeocodingResult>> = _address

    fun updateLocation(newLocation: LocationData){
        _location.value = newLocation
    }

    fun fetchAddress(latlng: String){
        //suspend func'ı cagiracagiz. onun icin courutine icinde cagirmamiz lazim.
        try{
            viewModelScope.launch {
                val result = RetrofitClient.create().getAddressFromCoordinates(
                    latlng,
                    "AIzaSyB4v2J70NpypTy5dJ9qJ0yY_HlUyK7mdTM"
                )
                _address.value = result.results
            }
        }catch(e:Exception) {
            //logcat mesaji
            Log.d("res1", "${e.cause} ${e.message}")
        }
    }
}