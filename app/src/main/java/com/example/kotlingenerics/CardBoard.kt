package com.example.kotlingenerics

class CardBoard :Container<BreakableThing>{


    private val items = mutableListOf<BreakableThing>()
    override fun canAddAnotherItem(): Boolean {
       return items.count() < 2
    }


    override fun canRemoveAnotherItem(): Boolean {
       return items.count() >0
    }

    override fun removeItem(): BreakableThing {

        val lastItem = items.last()
        items.remove(lastItem)
        return lastItem
    }

    override fun getAnother(): Container<BreakableThing> {
       return CardBoard()
    }

    override fun contents(): List<BreakableThing> {

        return items.toList()
    }


//Here functions has it's own generic type different than the class hence it is allowed at input position
    override fun <E> addItem(item: E) {
        items.add(item as BreakableThing)
    }

}