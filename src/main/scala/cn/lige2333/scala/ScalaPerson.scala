package cn.lige2333.scala

object ScalaPerson {

  def apply(pName: String): ScalaPerson = new ScalaPerson(pName)

  def apply(): ScalaPerson = new ScalaPerson("sb")
}
class ScalaPerson(pName:String){
  var name :String = pName
}

object guapi{
  def main(args: Array[String]): Unit = {
    val person = new ScalaPerson("guapi")
    val person2 = ScalaPerson("guagua")
    val person3 = ScalaPerson()
    println(person.name+person2.name+person3.name)
  }
}
