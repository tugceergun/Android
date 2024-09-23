package eu.tutorials.locationapp

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.os.Looper
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.google.android.gms.maps.model.LatLng
import java.util.Locale

//location izni olup olmadigini ogrenmek icin yardimci sinif.
class LocationUtils(val context: Context) {

    private val _fusedLocationClient: FusedLocationProviderClient
    = LocationServices.getFusedLocationProviderClient(context)

    //normalde; alttaki,
    // _fusedLocationClient.requestLocationUpdates(locationRequest,locationCallback, Looper.getMainLooper()) satirinda,
    //iznimiz olmasi gerektigi icin hata verir. SuppressLint ile bu izin hatasini bastiriyoruz.
    @SuppressLint("MissingPermission")
    fun requestLocationUpdates(viewModel: LocationViewModel){
        val locationCallback = object : LocationCallback(){
            override fun onLocationResult(locationResult: LocationResult) {
                super.onLocationResult(locationResult)
                locationResult.lastLocation?.let {
                    val location = LocationData(latitude = it.latitude, longitude = it.longitude)
                    viewModel.updateLocation(location)
                }
            }
        }

        //her bin ms'de bir konum istegi gonderir ve gunceller. sonra viewmodeli gunceller sonra user interface'i(LocationDisplay) gunceller.(location)
        val locationRequest = LocationRequest.Builder(
            Priority.PRIORITY_HIGH_ACCURACY,1000).build()
        _fusedLocationClient.requestLocationUpdates(locationRequest,locationCallback, Looper.getMainLooper())
    }

    fun hasLocationPermission(context: Context): Boolean{

        return ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                &&
                ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED

    }


    fun reverseGeocodeLocation(location: LocationData) : String{
        val geocoder = Geocoder(context, Locale.getDefault()) //telefonun varsayilan ayarinda adres verir.
        val coordinate = LatLng(location.latitude, location.longitude)
        val addresses:MutableList<Address>? =
            geocoder.getFromLocation(coordinate.latitude, coordinate.longitude, 1)
        return if(addresses?.isNotEmpty() == true){
            addresses[0].getAddressLine(0)
        }else{
            "Address not found."
        }
    }
}