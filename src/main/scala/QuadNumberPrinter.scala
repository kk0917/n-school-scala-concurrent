object QuadNumberPrinter extends App {
  private var counter = 0

  def next(): Int = synchronized {
    counter = counter + 1
    counter
  }

  for (i <- 1 to 4) {
    new Thread(() => for (j <- 1 to 1000) println(Thread.currentThread().getName + s"${i}: " + next())).start()
    new Thread(() => for (j <- 1 to 1000) println(Thread.currentThread().getName + s"${i}: " + next())).start()
    new Thread(() => for (j <- 1 to 1000) println(Thread.currentThread().getName + s"${i}: " + next())).start()
    new Thread(() => for (j <- 1 to 1000) println(Thread.currentThread().getName + s"${i}: " + next())).start()
  }
}
