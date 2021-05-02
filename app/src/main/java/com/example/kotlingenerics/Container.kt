package com.example.kotlingenerics

interface Container<out T>{

    fun canAddAnotherItem():Boolean

    fun <T> addItem(item:T)

    fun canRemoveAnotherItem():Boolean
    fun removeItem():T

    fun getAnother():Container<T>

    fun contents():List<T>
}


/*
* In case of put we use contravariant in case of get we use covariance
* Here we have declared class as invariant
* if we want some function we can add items and also accepts subclass of items we have to declare it with out T
* but that will restrict the add functionality because we might add itemType1 to list of itemType2
*
* Suppose we want to sort all the items based on it's type so we can use the comparator which is a Contravariant type
* that is it can accept any comparator of child class of super class of child
*
* for comparator we can pass the parent comparator to child
*
* in means inside of parent like animal is inside of a dog
*
* */