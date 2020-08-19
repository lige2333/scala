package cn.lige2333.scala

object TestScala {
  def main(args: Array[String]): Unit = {
    val n1 = 10
    val n2 = 20
    println(getRes(n1, n2, '+'))
    println(test(4))
    mysqlCon("127.0.0.1", 3305, "abc", "def")
    println(sum(6, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
  }

  def getRes(n1: Int, n2: Int, oper: Char) = {
    if (oper == '+') {
      n1 + n2
    } else if (oper == '-') {
      n1 - n2;
    } else {
      null
    }
  }

  def test(n: Int): Int = {
    if (n == 1) {
      3
    } else {
      2 * test(n - 1) + 1
    }
  }

  def mysqlCon(add: String = "localhost", port: Int = 3306, user: String = "root", pwd: String): Unit = {
    println("add=" + add)
    println("port=" + port)
    println("user=" + user)
    println("pwd=" + pwd)
  }

  def sum(n1: Int, args: Int*): Int = {
    println("length" + args.length)
    var sum = 0;
    for (item <- args) {
      sum += item
    }
    sum
  }
}
