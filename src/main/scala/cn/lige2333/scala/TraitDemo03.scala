object TraitDemo03 {
  def main(args: Array[String]): Unit = {
    val mySQL = new MySQL5 with DB5 with File5
    mySQL.insert(666)
  }
}

trait Operate5 {
  def insert(id: Int)
}

trait File5 extends Operate5 {
  abstract override def insert(id: Int): Unit = {
    println("saveFile")
    super.insert(id)
  }
}
trait DB5 extends Operate5{
  def insert(id:Int):Unit={
    println("saveDB")
  }
}
class MySQL5{

}