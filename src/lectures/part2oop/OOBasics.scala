package lectures.part2oop

object OOBasics extends App {
  val person = new Person("John", 26)
  println(person.x)
  person.greet("Asad")
  person.greet()

  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great expectations", 1861, author)
  println(novel.authorAge())
  println(novel.isWrittenBy(author))
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

/*
  Novel and a Writer

  Writer: first name, surname, year
  - method fullname

  Novel: name, year of release, author
  - authorAge
  - isWrittenBy(author)
  - copy (new year of release) = new instance of Novel
 */

/*
  Counter class
  - receives an int value
  - method current count
  - method to increment / decrement => new Counter
  - overload inc / dec to receive an amount

 */

// Class parameters are NOT FIELDS

class Writer(firstName: String, surname: String, val year: Int) {
  def fullName(): Unit = {
    println(firstName + " " + surname)
  }
}

class Novel(name: String, yearOfRelease: Int, author: Writer) {
  def authorAge(): Unit = {
    yearOfRelease - author.year
  }

  def isWrittenBy(author: Writer): Unit = {
    author == this.author
  }

  def copy(newYearOfRelase: Int): Novel = {
    new Novel(name, newYearOfRelase, author)
  }
}
