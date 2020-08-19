object TraitDemo01 {
  def main(args: Array[String]): Unit = {
    val oracleDB = new OracleDB with Operate3
    oracleDB.insert(100)
    val mySQL3 = new MySQL3 with Operate3
    mySQL3.insert(200)
    val mySQL4 = new MySQL4 with Operate3 {
      override def say(): Unit = {
        println("66666")
      }
    }
    mySQL4.insert(10)
    mySQL4.say()
  }
}

trait Operate3 {

  def insert(id: Int): Unit = {
    println("id:" + id)
  }
}

class OracleDB {

}

abstract class MySQL3 {

}

abstract class MySQL4 {
  def say()
}