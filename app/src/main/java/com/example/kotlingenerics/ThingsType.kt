package com.example.kotlingenerics



data class CheapThing(val name:String):Checkable{
    @Override
    override fun toString():String{
        return name
    }

    override fun checkIsOk(): Boolean {
        return false
    }
}


data class BreakableThing(
    val name:String,
    var isBroken:Boolean = false
):Checkable{
    override fun checkIsOk(): Boolean {
        return isBroken
    }

    @Override
   override fun toString():String{
        return name
    }
    fun smash(){
        isBroken = true
    }
}


//Interface for common functionality
interface Checkable{
    fun checkIsOk():Boolean
}
