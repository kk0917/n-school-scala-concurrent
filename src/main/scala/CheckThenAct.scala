object CheckThenAct extends App {
  for (i <- 1 to 10) {
    new Thread(() => println(SingletonProvider.get)).start()
  }
}

//object SingletonProvider {
//  private[this] var singleton: BigObject = _
//
//  def get: BigObject = this.synchronized {
//    if (singleton == null) {
//      singleton = new BigObject()
//    }
//    singleton
//  }
//}

object SingletonProvider {
  lazy val get: BigObject = new BigObject()
}

class BigObject() {
  Thread.sleep(100)
}
