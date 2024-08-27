package eu.tutorials.inheritanceapp

//Turetilmis sinif
//BaseClass 'tan kalitim alir.
open class Secondary: BaseClass() {

    override fun role() {
        //super.role() //"Member of the house BaseClass" yazdirir. (BaseClass'taki hali.)
        println("Knight of the house BaseClass")
    }
}