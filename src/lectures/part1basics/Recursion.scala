package lectures.part1basics

object Recursion extends App {
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)

      result
    }
  }

  println(factorial(1))

  def fact(n: Int): Int = {
    @scala.annotation.tailrec
    def helper(t: Int, acc: Int): Int = {
      if (t <= 1) acc
      else helper(t - 1, t * acc)
    }
    helper(n, 1)
  }

  println(fact(5))

  def anotherFactorial(n: Int): BigInt = {
    @scala.annotation.tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt = {
      //      println("N = " + x + " and accumulator is " + accumulator)
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator)
    }

    factHelper(n, 1)
  }

  println(anotherFactorial(5))

  /**
   * anotherFactorial(10) = factHelper(10, 1)
   * = factHelper(9, 10 * 1)
   * = factHelper(8, 9 * 10 * 1)
   * = factHelper(7, 8 * 9 * 10 * 1)
   * = factHelper(6, 7 * 8 * 9 * 10 * 1)
   * ...
   * = factHelper(2, 3 * 4 ... * 10 * 1)
   * = factHelper(1, 2 * 3 ... * 10 * 1)
   */

  // WHEN YOU NEED LOOPS, USE _TAIL_ RECURSION

  /**
   * 1. Concatenate a string n times
   * 2. IsPrime function tail recursion
   * 3. Fibonacci function, tail recursive
   */

  @scala.annotation.tailrec
  def concatenateTailRec(aString: String, n: Int, accumulator: String): String = {
    if (n <= 0) accumulator
    else concatenateTailRec(aString, n - 1, aString + accumulator)
  }

  println(concatenateTailRec("Hello", 3, ""))

  def isPrime(n: Int): Boolean = {
    @scala.annotation.tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailRec(t - 1, n % t != 0 && isStillPrime)
    }

    isPrimeTailRec(n / 2, isStillPrime = true)
  }

  def fibonacci(n: Int): Int = {
    def fibTailRec(t: Int, last: Int, nextToLast: Int): Int = {
      if (t >= n) last
      else fibTailRec(t + 1, last + nextToLast, last)
    }

    if (n <= 2) 1
    else fibTailRec(2, 1, 1)
  }

  println(fibonacci(8))
}
