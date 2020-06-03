package lectures.part1basics

object ValuesVariablesTypes extends App {
  val x: Int = 42
  println(x)

  // VALS ARE IMMUTABLE
  // TYPES OF VALS ARE OPTIONAL - Compiler can infer type

  val aString: String = "Hello"
  val anotherString: String = "Goodbye"

  val aBoolean: Boolean = true
  val aChar: Char = 'A'
  val anInt: Int = x
  val aShort: Short = 4613
  val aLong: Long = 234455334366644444L
  val aFloat: Float = 2.0F
  val aDouble: Double = 3.14

  // Variables
  var aVariable: Int = 4
  aVariable = 5 // Side effects
}
