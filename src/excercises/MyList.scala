package excercises

//abstract class MyList {
//  /*
//      head = first element of the list
//      tail = remainder of the list
//      isEmpty = is this list empty
//      add(int) => new list with this element added
//      toString => a string representation of the list
//   */
//  val myList: List[Int] = List(1, 2, 3)
//
//  def getHead: Int = {
//    myList.head
//  }
//
//  def getTail: List[Int] = {
//    myList.tail
//  }
//
//  def isEmpty: Boolean = {
//    myList.isEmpty
//  }
//
//  def add(intToAdd: Int): Unit = {
//    myList :+ intToAdd
//  }
//
//  override def toString: String = {
//    myList.toString()
//  }
//}

abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def printElements: String
  // polymorphic call
  override def toString: String = "[" + printElements + "]"
}

object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException
  override def tail: MyList[Nothing] = throw new NoSuchElementException
  override def isEmpty: Boolean = true
  override def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
  override def printElements: String = ""
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head: A = h
  override def tail: MyList[A] = t
  override def isEmpty: Boolean = false
  override def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  override def printElements: String = {
    if (t.isEmpty) "" + head
    else h + " " + t.printElements
  }
}

object ListTest extends App {
  val listOfIntegers: MyList[Int] = new Cons[Int](1, new Cons(2, new Cons(3, Empty)))
  val listOfStrings: MyList[String] = new Cons[String]("Hello", new Cons("Scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)
}
