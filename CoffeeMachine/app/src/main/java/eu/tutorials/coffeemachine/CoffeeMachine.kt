package eu.tutorials.coffeemachine

fun main () {

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

fun coffeeDetail(){
    println("Who is this coffee for?")
    val name = readln()
    println("How many pieces of sugar do you want?")
    val sugarCount = readln()
    val sugarCountInt = sugarCount.toInt()
    makeCoffee(sugarCountInt, name)
}

fun makeCoffee(sugarCount: Int, name: String){

    if(sugarCount>=0) {

        if(sugarCount==0){
            println("Coffe with no sugar for $name")
        }
        else if (sugarCount == 1) {
            println("Coffe with $sugarCount spoon of sugar for $name")
        } else {
            println("Coffee with $sugarCount spoons of sugar for $name")
        }
    }else{
        println("Invalid count.")
    }

}