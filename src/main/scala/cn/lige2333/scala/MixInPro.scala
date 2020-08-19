object MixInPro {
  def main(args: Array[String]): Unit = {
    val mySQL = new MySQL6 with DB6 {
      override var sal: Int = 666
    }
  }
}

trait DB6 {
  var opertype: String = "insert"
  var sal:Int
  def insert(): Unit = {

  }
}

class MySQL6{

}