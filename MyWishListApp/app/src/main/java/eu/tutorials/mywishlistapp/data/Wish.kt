package eu.tutorials.mywishlistapp.data

//wish hangi properties'leri almali
data class Wish(
    val id: Long = 0L,
    val title: String= "",
    val description: String=""
)

object DummyWishList{
    val wishList= listOf(
        Wish(title= "Google watch 2", description = "An android watch"),
        Wish(title= "Google watch 2", description = "An android watch"),
        Wish(title= "Google watch 2", description = "An android watch"),
        Wish(title= "Google watch 2", description = "An android watch")
    )
}