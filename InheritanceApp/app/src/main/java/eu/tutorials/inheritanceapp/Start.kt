package eu.tutorials.inheritanceapp

fun main() {

    /*
    val obj1 = BaseClass()
    obj1.coreValues()
    //Core values of house BaseClass -- cikti (Kalitim aliyor)

    val obj2 = Secondary()
    obj2.coreValues()
    //Core values of house BaseClass -- cikti (Kalitim aliyor)



    val obj3= Tertiary()
    obj3.role()
    //"Member of the house BaseClass" cikti

     */

    //frank baseClass, secondaryClass ozelliklerine ve interfacelerden(baba-teyze) aldigi ozelliklere sahip.
    val frank = Offspring()
    frank.archery()
    frank.role()
    frank.coreValues()
    frank.sing()


}