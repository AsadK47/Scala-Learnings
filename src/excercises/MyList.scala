package excercises

abstract class MyList {
  /*
      head = first element of the list
      tail = remainder of the list
      isEmpty = is this list empty
      add(int) => new list with this element added
      toString => a string representation of the list
   */
  val myList: List[Int] = List(1, 2, 3)

  def getHead: Int = {
    myList.head
  }

  def getTail: List[Int] = {
    myList.tail
  }

  def isEmpty: Boolean = {
    myList.isEmpty
  }

  def add(intToAdd: Int): Unit = {
    myList :+ intToAdd
  }

  override def toString: String = {
    myList.toString()
  }
}
