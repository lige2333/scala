package cn.lige2333.scala

object ScalaExceptionDemo {
  def main(args: Array[String]): Unit = {
    try{
      val r = 10/0
    }catch {
      case ex:ArithmeticException => println("shuxue")
      case ex:Exception => println("dayichang")
    }finally {
      println("jieshu")
    }
    val res = test()
  }

  @throws(classOf[Exception])
  def test():Nothing={
    throw new Exception("chushile")
  }
}
