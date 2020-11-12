import java.time.LocalDateTime
import java.util.concurrent.atomic.AtomicReference
import java.util.function.UnaryOperator

object LongLock extends App {
  for (i <- 1 to 100) {
    new Thread(() => println(NumAndCurrentDateProvider.next)).start()
  }
}

object NumAndCurrentDateProvider {
  private[this] val lastNumber = new AtomicReference[BigInt](BigInt(0))

//  def next: (BigInt, LocalDateTime) = synchronized {
//    val nextNumber = synchronized {
//      lastNumber.updateAndGet(new UnaryOperator[BigInt] {
//        override def apply(t: BigInt): BigInt = t + 1
//      })
//    }
//    (nextNumber, currentDateSoHeavy)
//  }
  def next: (BigInt, LocalDateTime) = {
    val nextNumber = lastNumber.updateAndGet(new UnaryOperator[BigInt] {
      override def apply(t: BigInt): BigInt = t + 1
    })
    (nextNumber, currentDateSoHeavy)
  }

  def currentDateSoHeavy: LocalDateTime = {
    Thread.sleep(100)
    LocalDateTime.now()
  }
}

object Summary {
  /**
   * スレッドセーフは、複数のスレッドからのアクセスをした際に正しく振る舞える性質
   * 可変の状態には、書き込みだけではなく読み取りした後の処理にもロックをかける必要がある
   * synchronized ブロックでロックした処理が時間のかかる処理である場合、全体のパフォーマンスが下がることがある
   */
}
