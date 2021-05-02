package com.example.kotlingenerics



/*fun List<String>.toBulletList():String{
    val separator = "\n -"
    return  this.map { "$it" }.joinToString(separator,prefix = separator,postfix = "\n")

}*/

//<T> means it is generic function
fun <T> List<T>.toBulletList():String{
    val separator = "\n -"
    return  this.map { "$it" }.joinToString(separator,prefix = separator,postfix = "\n")

}
