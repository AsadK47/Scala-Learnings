package lectures.part1basics

object DefaultArgs extends App {
  def factorial(n: Int): Int = {
    @scala.annotation.tailrec
    def factTailRec(t: Int, acc: Int): Int = {
      if (t <= 1) acc
      else factTailRec(t - 1, t * acc)
    }

    factTailRec(n, 1)
  }

  @scala.annotation.tailrec
  def trFact(n: Int, acc: Int = 1): Int = {
    if (n <= 1) acc
    else trFact(n - 1, n * acc)
  }

  val fact10 = trFact(5)
  println(fact10)

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = {
    println("Save picture")
  }
  savePicture(width = 800)

  /*
   * 1, Pass in every leading argument
   * 2. Name the arguments
   */

  savePicture(height = 600, width = 800, format = "bmp")
}
