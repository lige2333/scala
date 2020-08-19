package cn.lige2333.scala

import scala.beans.BeanProperty

object tooyoung {
  def main(args: Array[String]): Unit = {
    val p1 = new Person("431243")
    println(p1)
  }

}

class Person (inName: String, inAge: Int) {
  @BeanProperty var age: Int = inAge
  var Name: String = inName

  age +=10
  println("~~~~~~~~~")

  override def toString: String = {

    "name=" + this.Name + "age=" + this.age
  }

  def this(name:String){
    this("jack",10)
    this.Name = name
    println("ok"+name)
  }

  println("ok")
}