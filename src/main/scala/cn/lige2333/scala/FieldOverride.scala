package cn.lige2333.scala

object FieldOverride {
  def main(args: Array[String]): Unit = {
    val obj:AAA = new BBB
    val obj2:BBB = new BBB
    println("1age"+obj.age+"2age"+obj2.age)
  }
}

abstract class AAA {
  var name:String
  val age: Int = 10
  def cry();
}

class BBB extends AAA {
  override var name: String = "sb"
  override val age: Int = 20

  override def cry(): Unit = {

  }
}