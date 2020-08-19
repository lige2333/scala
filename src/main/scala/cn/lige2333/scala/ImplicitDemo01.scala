object ImplicitDemo01 {
  def main(args: Array[String]): Unit = {
    implicit def addDelete(mysql: MySQL7): DB7 = {
      new DB7
    }

    val mySQL = new MySQL7
    mySQL.insert()
    mySQL.delete()
  }
}
class MySQL7{
  def insert():Unit={
    println("insert")
  }
}
class DB7{
  def delete():Unit={
    println("delete")
  }
}