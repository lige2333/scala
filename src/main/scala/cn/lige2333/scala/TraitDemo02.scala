object TraitDemo02 {
  def main(args: Array[String]): Unit = {
    val mysql = new MySQL200 with File4 with DB4
    mysql.insert(100)
  }
}

trait Operate4 {
  println("operate4")

  def insert(id: Int)
}

trait Data4 extends Operate4 {
  println("Data4")

  def insert(id: Int): Unit = {
    println("id:" + id)
  }
}

trait DB4 extends Data4 {
  println("DB4")

  override def insert(id: Int): Unit = {
    println("数据库")
    super.insert(id)
  }
}

trait File4 extends Data4 {
  println("File4")

  override def insert(id: Int): Unit = {
    println("文件")
    super.insert(id)
  }
}

class MySQL200 {}