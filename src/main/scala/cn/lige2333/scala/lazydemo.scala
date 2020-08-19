package cn.lige2333.scala

object lazydemo {
  def main(args: Array[String]): Unit = {
    lazy val res = sum(10,20)
    println("___________")
    println("res="+res)
  }

  def sum(n1: Int, n2: Int): Int = {
    println("sum")
    return n1 + n2
  }
}
