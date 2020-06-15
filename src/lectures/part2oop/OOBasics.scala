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
  println(novel.isWrittenBy(imposter))

  val counter = new Counter()
  counter.inc.print()
  counter.inc.inc.inc.print()
  counter.inc(10).print()
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
  def authorAge(): Int = {
    yearOfRelease - author.year
  }

  def isWrittenBy(author: Writer): Boolean = {
    author == this.author
  }

  def copy(newYearOfRelease: Int): Novel = {
    new Novel(name, newYearOfRelease, author)
  }
}

class Counter(val count: Int = 0) {
  def inc = {
    println("incrementing")
    new Counter(count + 1) // immutability
  }

  def dec = {
    println("decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n - 1)
  }

  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n - 1)
  }

  def print(): Unit = println(count)
}
