package cn.lige2333.scala

object TypeConvert {
  def main(args: Array[String]): Unit = {
    var person = new Person2
    println(person.getClass.getName)
    var gay = new gay2
    person = gay
    var gay2 = person.asInstanceOf[gay2]
    var les = new les2
    test(gay2)
    test(les)
  }

  def test(p: Person2): Unit = {
    if(p.isInstanceOf[gay2]){
      p.asInstanceOf[gay2].gays()
    }else if(p.isInstanceOf[les2]){
      p.asInstanceOf[les2].less()
    }
  }
}

class Person2 {
  val name = "nick"

  def play(): Unit = {
    println(this.name)
  }
}

class gay2 extends Person2 {
  override def play(): Unit = {
    println("nannan")
  }

  def gays() = {
    println("gaygaygay")
  }
}

class les2 extends Person2 {
  override def play(): Unit = {
    println("nvnv")
  }

  def less() = {
    println("leslesles")
  }
}