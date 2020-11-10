object ThreadSample extends App {
  println(Thread.currentThread().getName)

  val thread = new Thread(() => {
    Thread.sleep(1000)
    println(Thread.currentThread().getName)
  }) // = new Runnable { override def run(): Unit = ??? } # java.lang.Runnable
  thread.start()

  println("main thread finished.")
}
