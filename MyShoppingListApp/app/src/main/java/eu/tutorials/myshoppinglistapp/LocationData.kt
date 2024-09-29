package eu.tutorials.myshoppinglistapp

data class LocationData(
    val latitude: Double,
    val longitude: Double
)

//google maps api'ne yaptigimiz ve bize geri donen istek.
data class GeocodingResponse(
    val results: List<GeocodingResult>,
    val status: String
)

data class GeocodingResult(
    val formatted_address: String
)