package lectures.part2oop

object OOBasics extends App {
  val person = new Person("John", 26)
  println(person.x)
  person.greet("Asad")
  person.greet()
}

// Constructor
class Person(name: String, val age: Int = 0) {
  // Body
  val x = 2

  println(1 + 3)

  // Method
  def greet(name: String): Unit = {
    println(s"${this.name} says Hi, $name")
  }

  // Overloading
  def greet(): Unit = println(s"Hi, I am ${name}") // this is implied here

  // Multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}

// Class parameters are NOT FIELDS