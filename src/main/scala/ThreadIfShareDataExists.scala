object ThreadIfShareDataExists extends App {
  private var counter = 0

  // Bad case..., many thread conflicting, each thread were not guaranteed
//  def next(): Int = {
//    counter = counter + 1
//    counter
//  }
  /**
   * scala src/main/scala/ThreadIfShareDataExists.scala
   * 1
   * 2
   * 3
   * ...
   * 99992
   * 99993
   * 99994
   */

  // Thread Safe if executing with synchronized
  def next(): Int = synchronized {
    counter = counter + 1
    counter
  }

  for (i <- 1 to 10) {
    new Thread(() => for (j <- 1 to 10000) println(next())).start()
  }
}
