package com.example.kotlingenerics

import kotlin.math.exp


fun main(){
   // printList()

    genericClassesPractice()


    //Out --> we can read from structure but cannot write (Used when we want type safe of a object from a structure while reading)
    //In-->  we can write from structure but cannot read(Used when we want to add only generic values into the structure)


//In and Out to tell the compiler what it can do

    val ints = listOf(1, 2, 3)
    val numbers: List<Number> = ints  //works because int is subtype of number ,, hence anything returned from list will be of type Number

   // val moreInts: List<Int> = numbers // List of int is List<out Int> that is it can return Int ,, but you cannot return Number from it as number could be float

   // Mutable list is for generic behaviour it does both accepts and returns so type has to be of same type


    val mutableInts = mutableListOf(1, 2, 3)
  //  val mutableNumbers: MutableList<Number> = mutableInts // -> Not allowed because it also accepts Numbers which could be of Float and subtypes can't be used interchangeably


}


fun compare(comparator: Comparable<Number>) {
    val int: Int = 1
    comparator.compareTo(int)
    val float: Float = 1.0f
    comparator.compareTo(float)


    val intComparable: Comparable<Int> = comparator

    intComparable.compareTo(int)
    //intComparable.compareTo(float)
}

fun printList(){
    val names = listOf("Bob","marley","ted","rock")
    println("Names :${names.toBulletList()}")

    val map = mapOf(
        Pair("one",1),
        Pair("two",2),
        Pair("three",3)
    )
    val valuesForKeyWithE =map.keys.filter { it.contains("e") }.map { "vale for $it : ${map[it]}" }
  //  println("Value for key With E  $valuesForKeyWithE")

    println("values for E: ${valuesForKeyWithE.toBulletList()}")


    val ints = listOf(1,2,3)
    println("Values of ints :${ints.toBulletList()}")


}


fun genericClassesPractice(){
    val cheapThings = listOf(
        CheapThing("block table"),
        CheapThing("books"),
        CheapThing("couch")
    )

    val cheapMover = Mover(cheapThings)
    cheapMover.moveEverythingToTruck(null)
    cheapMover.moveEverythingIntoNewPlace()
    cheapMover.finishMove()

    val television  = BreakableThing("Flat screen TV")
    val breakableThingList = listOf(
        television,
        BreakableThing("Washing machine"),
        BreakableThing("Guitar"),
    )

    television.smash()

    val expensiveMover = Mover<BreakableThing>(breakableThingList)
    expensiveMover.moveEverythingToTruck(CardBoard())
    expensiveMover.moveEverythingIntoNewPlace()
    expensiveMover.finishMove()
}

inline fun <reified T> genericsExample() {
   // println(value)
    println("Type of T: ${T::class.java}")
}
