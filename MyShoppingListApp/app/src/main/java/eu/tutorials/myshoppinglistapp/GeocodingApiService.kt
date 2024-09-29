package eu.tutorials.myshoppinglistapp

import retrofit2.http.GET
import retrofit2.http.Query

interface GeocodingApiService {

    @GET("maps/api/geocode/json") //api url endpoint. devami latlng ve apikey iceriyor.
    suspend fun getAddressFromCoordinates(
        @Query("latlng") latlng: String,
        @Query("key") apiKey: String
    ): GeocodingResponse
    //GeocodingResponse, alacagimiz yanittir. result(GeocodingResult listesi) ve status(baslangic durumu)
}