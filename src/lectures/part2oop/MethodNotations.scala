package lectures.part2oop
import scala.language.postfixOps

object MethodNotations extends App {

  class Person(val name: String, favouriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favouriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def unary_! : String = s"$name, what the heck!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, name is $name and I like $favouriteMovie"

    def +(nickname: String): Person = new Person(s"$name ($nickname)", favouriteMovie, age)
    def unary_+(): Person = new Person(name, favouriteMovie, age + 1)

    def learns(subject: String): String = s"${this.name} learns ${subject}"
    def learnsScala: String = this learns "Scala"
    def apply(numberOfTimes: Int) = s"${this.name} watched ${this.favouriteMovie} ${numberOfTimes} times"
  }

  val mary = new Person("Mary", "Inception", 25)

  println((mary + "the rockstar").apply())
  println((+mary).age)
  println(mary learnsScala)
  println(mary(2))

  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent
  // infix notation == operator notation (an example of syntactic sugar)

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club", 25)
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  // ALL OPERATORS ARE METHODS.
  // Akka actors have ! ?

  // prefix notation
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_ prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)

  // postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  // apply
  println(mary.apply())
  println(mary()) // equivalent

  /*
    1. Overload the + operator
       mary + "the rockstar" => new Persons "Mary (the rockstar)"

    2. Add an age to the Person class
       Add a unary + operator => new Person with the age + 1
       +mary => mary with the age incrementer

    3. Add a "learns" method in the Person class => "Mary learns Scala"
       Add a learnScala method, calls learn method with "Scala"
       Use it in postfix notation

    4. Overload the apply method
       mary.apply(2) => "Mary watched Inception 2 times"
   */
}
