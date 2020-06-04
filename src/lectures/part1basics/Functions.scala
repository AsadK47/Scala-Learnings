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

  def factorialFunction(n: Int): Int = {
    if (n <= 2) n
    else n * factorialFunction(n - 1)
  }

  println(factorialFunction(3))

  def fibonacciFunction(n: Int): Int = {
    if (n == 0 || n == 1) n
    else fibonacciFunction(n - 2) + fibonacciFunction(n - 1)
  }

  println(fibonacciFunction(3))

  def froggy(n: Int): Int = {
    if (n == 2) 2
    else if (n < 2) 1
    else froggy(n - 1) + froggy(n - 2)
  }

  println(froggy(4))

  def isPrime(n: Int): Boolean = {
    @scala.annotation.tailrec
    def isPrimeUntil(t: Int): Boolean = {
      println("N is " + n + " and T is " + t)
      if (t <= 1) true
      else  n % t != 0 && isPrimeUntil(t - 1)
    }

    isPrimeUntil(n / 2)
  }

  println(isPrime(9))

  def checkDiv(): Int = {
    9 / 2
  }

  println(checkDiv())
}
