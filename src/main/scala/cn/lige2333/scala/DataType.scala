package cn.lige2333.scala

object DataType {
  def main(args: Array[String]): Unit = {
    val res = sayHello()
    println(res)
    val dog:Dog = null
    var `var` = "var"
  }
  def sayHello(): Unit = {

  }
}
class Dog{
  var  age:Int = 0
  var name:String = ""
}
