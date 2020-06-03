package lectures.part1basics

object Functions extends App {
  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("Hello", 3))

  def aParameterLessFunction(): Int = 42

  println(aParameterLessFunction())
  println(aParameterLessFunction)

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("Hello", 3))

  // WHEN YOU NEED LOOPS, USE RECURSION.

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n - 1)
  }

  /*
    1. A greeting function(name, age) => "Hi, my name is $name and I am $age years old"
    2. Factorial function 1 * 2 * 3 * .. * n (recursive function)
    3. A Fibonacci function
       f(1) = 1
       f(2) = 1
       f(n) = f(n - 1) + f(n - 2)
    4. Tests if a number is prime
   */

  def greetingFunction(name: String, age: Int): Unit = {
    var message: String = "Hi, my name is " + name + " and I am " + age + " years old."
    println(message)
  }

  greetingFunction("Asad", 25)

  def factorialFunction(n: Int): Unit = {
    if (n <= 2) return n
    else n * factorialFunction(n - 1)
  }

  factorialFunction(3)
}
