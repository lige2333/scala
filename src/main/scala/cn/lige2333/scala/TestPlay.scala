package cn.lige2333.scala

object TestPlay {
  def main(args: Array[String]): Unit = {
    var num = 10
    println(num.isInstanceOf[Int])
    var age = 10
    age = 30
    val num2 = 50
    val dog = new Dog2
    dog.age=90
    dog.name="abc"
    val f1 = dog.sum _
    println(f1(50,60))
    val f2 = (n1:Int,n2:Int) =>{
      n1+n2
    }
    println(f2(50,60))
  }

}
class Dog2{
  var  age:Int = 0
  var name:String = ""
  def sum(n1:Int,n2:Int): Int = {
    n1+n2
  }
}