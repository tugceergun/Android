package eu.tutorials.coffeemachine

data class CoffeeDetails(
    val sugarCount: Int,
    val name: String,
    val size: String,
    val creamAmount: Int
)

fun main () {

    //data class nesnesi olusturuldu.
    val coffeForDennis = CoffeeDetails(1,"Dennis", "xl", 0)
    makeCoffee(coffeForDennis)

    /* Counting---
   println("number 1?")
    val num1 = readln() //string
    val num1Int= num1.toInt() //return integer

    println("number 2?")
    val num2 = readln()
    val num2Int = num2.toInt()

    //val myResult= add(num1Int,num2Int)
    val myResult= divide(num1Int,num2Int)
    println("Result: $myResult")

     ---*/
}
/* Counting---
fun divide (num1: Int, num2: Int): Double{ //return icin :Double ekledik. Dondurecegi deger.
    val result = num1 / num2.toDouble()
    return result
}

fun add (num1: Int, num2: Int): Int{ //return icin :Int ekledik. Dondurecegi deger.
    val result = num1 + num2
    return result
}
 ---*/

fun askCoffeeDetails(){
    println("Who is this coffee for?")
    val name = readln()
    println("How many pieces of sugar do you want?")
    val sugarCount = readln()
    val sugarCountInt = sugarCount.toInt()
    //makeCoffee(sugarCountInt, name)
}

//coffeeDetails'i parametre olarak alıyor ve seker sayisina gore cikti uretiyor.
fun makeCoffee(coffeeDetails: CoffeeDetails){

    if(coffeeDetails.sugarCount>=0) {

        if(coffeeDetails.sugarCount==0){
            println("Coffee with no sugar for ${coffeeDetails.name} + and cream:" +
                    "\"${coffeeDetails.creamAmount}\")")
        }
        else if (coffeeDetails.sugarCount == 1) {
            println("Coffee with ${coffeeDetails.sugarCount} " +
                    "spoon of sugar for ${coffeeDetails.name} + and cream:" +
                    "${coffeeDetails.creamAmount}")
        } else {
            println("Coffee with ${coffeeDetails.sugarCount} spoons of sugar for ${coffeeDetails.name} + and cream:" +
                    "\"${coffeeDetails.creamAmount}\")")
        }
    }else{
        println("Invalid count.")
    }

}