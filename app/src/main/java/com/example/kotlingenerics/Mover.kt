package com.example.kotlingenerics


//Class will retain the information about generic constraint (checkable) not able generic type
class Mover<T:Checkable>(
    thingsToMove: List<T>,
    val truckHeightInches: Int = (12 * 12)
) {

    private var thingsLeftInOldPlace = mutableListOf<T>()
   // private var thingsInTruck = mutableListOf<T>()
   private var thingsInTruck = mutableListOf<Any>()
    private var thingsInNewPlace = mutableListOf<T>()
    private var thingsFailedToMove = mutableListOf<T>()



    init {

        //check the compile code of below line
        genericsExample<Container<*>>()
        thingsLeftInOldPlace.addAll(thingsToMove)
    }


    //Here we are checking if type if of specific type that reduces the power of generics class shouldn't need to know what specific type T is in. Use interfaces for that
    /*  fun moveEverythingToTruck(){
          while (thingsLeftInOldPlace.count() > 0){
              val item = thingsLeftInOldPlace.removeAt(0)
              if( item is BreakableThing){
                  if(!item.isBroken){
                      thingsInTruck.add(item)
                      println("Moved your $item to the truck")
                  }else{
                      println("Could not move your $item to truck")
                  }
              }else{
                  thingsInTruck.add(item)
                  println("Moved $item to truck")
              }

          }
      }
  */
    fun  moveEverythingToTruck(emptyContainer: Container<T>?) {
        var currentContainer = emptyContainer
        while (thingsLeftInOldPlace.count() > 0) {
            val item = thingsLeftInOldPlace.removeAt(0)
                if (!item.checkIsOk()) {

                    if(currentContainer != null){
                        if(!currentContainer.canAddAnotherItem()){
                            moveContainerToTruck(currentContainer)
                            currentContainer = currentContainer.getAnother()
                        }
                        currentContainer.addItem(item)
                        println("Packed your Item $item")
                    }else{
                        thingsInTruck.add(item)
                        println("Moved your $item to the truck")
                    }

                } else {
                    thingsFailedToMove.add(item)
                 println("Could not move your $item to truck")
            }

        }

        currentContainer?.let {
            moveContainerToTruck(it)
        }
    }

    fun moveContainerToTruck(container: Container<T>){
        thingsInTruck.add(container)
        println("Moved a container with your items ${container.contents().toBulletList()} to the truck")
    }


    fun moveEverythingIntoNewPlace() {
        val containers = thingsInTruck.filterIsInstance<Container<T>>()
      //  val breakableThings2 = thingsInTruck.filterIsInstance<T>() ==> Error
     //  val things = thingsInTruck.filterIsInstance<Container<*>>() ==> Item will be any?

        for(container in containers){
            thingsInTruck.remove(container)
            while(container.canRemoveAnotherItem()){
                val itemInContainer = container.removeItem()
                println("Unpacked your $itemInContainer")
                 tryToMoveItemIntoNewPlace(itemInContainer)
            }
        }


        while (thingsInTruck.count() > 0) {
            val item = thingsInTruck.removeAt(0) as? T

           /* if(item  is Container<*>){
                val itemInConatiner  = item.removeItem()
            }*/
            if(item !=null){
                tryToMoveItemIntoNewPlace(item)

            }else{
                println("Something in the truck was not of expected generic Type $item")
            }



        }
    }

    fun tryToMoveItemIntoNewPlace(item:T){
        if(!item.checkIsOk()){
            thingsInNewPlace.add(item)
            println("Moved your $item to the palace")
        }else {
            thingsFailedToMove.add(item)
            println("Could not move your $item to new palace")
        }
    }

    fun finishMove() {
        println("Finished we were able to move your : ${thingsInNewPlace.toBulletList()}")

        if(thingsFailedToMove.isNotEmpty()){
            println("We failed to move your ${thingsFailedToMove.toBulletList()}")
        }
    }

}