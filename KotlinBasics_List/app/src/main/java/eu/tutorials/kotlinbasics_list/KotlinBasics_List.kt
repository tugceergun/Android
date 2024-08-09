package eu.tutorials.kotlinbasics_list

fun main() {

    // immutable list. cant add item
    //val shoppingList = listOf("Processor", "RAM", "Graphics Card", "SSD")

    //mutable list. can add item and modify.
    val shoppingList = mutableListOf("Processor", "RAM", "Graphics Card", "SSD")

    shoppingList.add("Cooler system")
    shoppingList.remove("Graphics Card")
    shoppingList.add("Graphics Card RTX 4090")

    println(shoppingList)

    shoppingList.removeAt(2)
    shoppingList.removeAt(1)

    shoppingList.add(2,"RAM")
    println(shoppingList)
    println(shoppingList[3])

    shoppingList[3] = "Graphic Card RX 7800XT"
    println(shoppingList)

    //replace item
    shoppingList.set(1,"Water Cooling")
    println(shoppingList)

    //contain
    val hasRam = shoppingList.contains("RAM")
    if(hasRam){
        println("Has RAM in the list.")
    }else {
        println("There is no RAM in the list.")
    }

    /*
    for(item in shoppingList){
        println(item)
        if(item == "RAM"){
            shoppingList.removeLast()
            break
        }
    }
    */

    println(shoppingList.size)
    for(index in 0 until  shoppingList.size){
        println("item ${shoppingList[index]} is at index $index")
    }




    println(shoppingList)

}